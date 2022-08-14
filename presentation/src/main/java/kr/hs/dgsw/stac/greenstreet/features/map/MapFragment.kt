package kr.hs.dgsw.stac.greenstreet.features.map

import android.content.Context.LOCATION_SERVICE
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import com.naver.maps.map.util.FusedLocationSource
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.stac.domain.model.post.Posting
import kr.hs.dgsw.stac.greenstreet.R
import kr.hs.dgsw.stac.greenstreet.adapter.HomePostAdapter
import kr.hs.dgsw.stac.greenstreet.base.BaseFragment
import kr.hs.dgsw.stac.greenstreet.databinding.FragmentMapBinding
import java.util.*

@AndroidEntryPoint
class MapFragment : BaseFragment<FragmentMapBinding, MapViewModel>(R.layout.fragment_map), OnMapReadyCallback {
    override val viewModel: MapViewModel by viewModels()
    override val hasBottomNav: Boolean = true
    private lateinit var naverMap: NaverMap
    private lateinit var locationSource: FusedLocationSource
    lateinit var homePostingAdapter: HomePostAdapter

    override fun start() {
        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.getMapAsync(this)
        setHomePostingRecyclerView()

        bindingViewEvent {
            when (it) {
                MapViewModel.EVENT_ON_CLICK_MY_INFO -> findNavController().navigate(R.id.action_main_map_to_myInfoFragment)
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


        viewModel.getPostingTest()
        observePostingList()
        setGPSLocation()
    }

    private fun observePostingList() {
        viewModel.postingList.observe(this) { postingList ->
            setMarker(postingList)
            homePostingAdapter.submitList(postingList)
        }
    }

    private fun setMarker(postingList: List<Posting>) {
        postingList.forEach { posting ->
            val marker = Marker()
            marker.position = LatLng(posting.lat, posting.lng)
            marker.map = naverMap
            marker.tag = posting.id
            val markerIcon =
                if (posting.status == "FINISH")
                    OverlayImage.fromResource(R.drawable.ic_resolved)
                else
                    OverlayImage.fromResource(R.drawable.ic_unresolved)
            marker.icon = markerIcon
        }
    }

    private fun setGPSLocation() {
        val locationManager: LocationManager = activity?.getSystemService(LOCATION_SERVICE) as LocationManager
        val currentLocation: Location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)!!
        val lat = currentLocation.latitude // 위도
        val lng = currentLocation.longitude // 경도
        context?.let {
            val geocoder = Geocoder(it, Locale.KOREA)
            var address = "주소 오류"
            try {
                val splitAddress = geocoder.getFromLocation(lat, lng, 1).first().getAddressLine(0).split(" ")
                address = "${splitAddress[1]} ${splitAddress[2]} ${splitAddress[3]}"
            } catch (e: Exception) {
                e.printStackTrace()
            }
            binding.tvLocation.text = address
        }
    }

    private fun setHomePostingRecyclerView() {
        homePostingAdapter = HomePostAdapter()
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