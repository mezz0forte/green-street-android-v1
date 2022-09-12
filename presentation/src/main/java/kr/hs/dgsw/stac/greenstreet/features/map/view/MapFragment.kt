package kr.hs.dgsw.stac.greenstreet.features.map.view

import android.content.Context.LOCATION_SERVICE
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraAnimation
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import com.naver.maps.map.util.FusedLocationSource
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.features.map.adpater.HomePostAdapter
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentMapBinding
import kr.hs.dgsw.stac.greenstreet.features.map.vm.MapViewModel
import kr.hs.dgsw.stac.greenstreet.util.myLocationGPSToAddress

@AndroidEntryPoint
class MapFragment :
    BaseFragment<FragmentMapBinding, MapViewModel>(R.layout.fragment_map),
    OnMapReadyCallback {
    override val viewModel: MapViewModel by viewModels()
    override val hasBottomNav: Boolean = true
    private lateinit var naverMap: NaverMap
    private lateinit var locationSource: FusedLocationSource
    private lateinit var homePostingAdapter: HomePostAdapter

    override fun start() {
        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.getMapAsync(this)
        setHomePostingRecyclerView()

        bindingViewEvent {
            when (it) {
                MapViewModel.EVENT_ON_CLICK_MY_INFO -> findNavController().navigate(R.id.action_main_map_to_myInfoFragment)
                MapViewModel.EVENT_ON_CLICK_RANK -> findNavController().navigate(R.id.action_main_map_to_rankFragment)
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return
        }
        if (locationSource.onRequestPermissionsResult(requestCode, permissions, grantResults)) {
            if (!locationSource.isActivated) {
                naverMap.locationTrackingMode = LocationTrackingMode.None
            }
            return
        }
    }

    override fun onMapReady(map: NaverMap) {
        naverMap = map
        locationSource = FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)
        naverMap.locationSource = locationSource
        naverMap.locationTrackingMode = LocationTrackingMode.Follow
        naverMap.maxZoom = 18.0
        naverMap.minZoom = 10.0
        with(naverMap.uiSettings) {
            isLocationButtonEnabled = false
            logoGravity = Gravity.END.or(Gravity.TOP)
            setLogoMargin(0, 150, 16, 0)
            isCompassEnabled = false
            isZoomControlEnabled = false
        }

        binding.locationView.map = naverMap

        viewModel.getAllPostings()
        observeViewModel()
        setMyGPSAddress()
    }

    private fun observeViewModel() {
        with(viewModel) {
            error.observe(this@MapFragment) {
                context?.let { context ->
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                }
            }
            postingList.observe(this@MapFragment) { postingList ->
                setMarker(postingList)
                homePostingAdapter.submitList(postingList)
            }
        }
    }

    private fun setMarker(postingList: List<Posting>) {
        postingList.forEach { posting ->
            val marker = Marker()
            marker.position = LatLng(posting.latitude, posting.longitude)
            marker.map = naverMap
            marker.tag = posting.id
            val markerIcon =
                if (posting.status == "FINISH")
                    OverlayImage.fromResource(R.drawable.ic_resolved)
                else
                    OverlayImage.fromResource(R.drawable.ic_unresolved)
            marker.icon = markerIcon
            marker.setOnClickListener {
                val action = MapFragmentDirections.actionMainMapToDetailPostFragment(it.tag as Long)
                findNavController().navigate(action)
                true
            }
        }
    }

    private val locationListener = LocationListener { location ->
        Log.d("LocationListenerTest", "실행됨")
        context?.let {
            binding.tvLocation.text = it.myLocationGPSToAddress(location.latitude, location.longitude)
        }
    }
    private fun setMyGPSAddress() {
        context?.let { context ->
            val locationManager: LocationManager = activity?.getSystemService(LOCATION_SERVICE) as LocationManager
            locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)?.let {
                binding.tvLocation.text = context.myLocationGPSToAddress(it.latitude, it.longitude)
            }
            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                1000L,
                30f,
                locationListener
            )
        }
    }

    private fun setHomePostingRecyclerView() {
        homePostingAdapter = HomePostAdapter { latlng ->
            val cameraUpdate = CameraUpdate.scrollAndZoomTo(latlng, 100.0).animate(CameraAnimation.Easing)
            naverMap.moveCamera(cameraUpdate)
        }
        binding.rvHomePosting.adapter = homePostingAdapter
    }

    // 아래 수명주기 연결
    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.mapView.onSaveInstanceState(outState)
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    companion object {
        private val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }
}
