package kr.hs.dgsw.stac.greenstreet.features.post.add

import android.app.Activity
import android.content.Intent
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.FileProvider
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import com.naver.maps.map.CameraAnimation
import com.naver.maps.map.CameraUpdate
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.adapter.AddImageAdapter
import kr.hs.dgsw.stac.greenstreet.adapter.HomePostAdapter
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentAddPostBinding
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class AddPostFragment : BaseFragment<FragmentAddPostBinding, AddPostViewModel>(R.layout.fragment_add_post) {
    override val viewModel: AddPostViewModel by viewModels()
    val REQUEST_IMAGE_CAPTURE = 1
    lateinit var currentPhotoPath : String
    private lateinit var addImageAdapter: AddImageAdapter

    override fun start() {
        settingPermission()
        observePostingList()
        setPostPostingRecyclerView()


        bindingViewEvent {
            when(it) {
                AddPostViewModel.EVENT_ON_CLICK_BACK -> {
                    findNavController().popBackStack()
                }
                AddPostViewModel.EVENT_ON_CLICK_ADDIMG -> {
                    startCapture()

                }
                AddPostViewModel.EVENT_ON_CLICK_NEXT -> {
                    findNavController().popBackStack()
                    Toast.makeText(context, "임시 테스트", Toast.LENGTH_LONG).show()
                }

            }
        }
    }

    private fun observePostingList() {
        viewModel.imageList.observe(this) { imageList ->
            addImageAdapter.submitList(imageList)
        }
    }

    private fun setPostPostingRecyclerView() {
        addImageAdapter = AddImageAdapter()
        binding.rvPostImage.adapter = addImageAdapter
    }


    private fun settingPermission(){
        var permis = object  : PermissionListener {
            override fun onPermissionGranted() {

            }

            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                Toast.makeText(requireContext(), "권한 거부", Toast.LENGTH_SHORT)
                    .show()
                ActivityCompat.finishAffinity(requireActivity()) // 권한 거부시 앱 종료
            }
        }

        TedPermission.create()
            .setPermissionListener(permis)
            .setRationaleMessage("카메라 사진 권한 필요")
            .setDeniedMessage("카메라 권한 요청 거부")
            .setPermissions(
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.CAMERA)
            .check()
    }

    private fun startCapture(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(requireActivity().packageManager)?.also {
                val photoFile: File? = try{
                    createImageFile()
                }catch(ex: IOException){
                    null
                }
                photoFile?.also{
                    val photoURI : Uri = FileProvider.getUriForFile(
                        requireContext(),
                        "kr.hs.dgsw.stac.greenstreet",
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }

    @Throws(IOException::class)
    private fun createImageFile() : File {
        val timeStamp : String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir : File? = requireActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_",
            ".jpg",
            storageDir
        ).apply{
            currentPhotoPath = absolutePath
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK){
            val file = File(currentPhotoPath)
            val uri = Uri.fromFile(file)
            viewModel.imageList.postValue(listOf(uri))

        }
    }

}
