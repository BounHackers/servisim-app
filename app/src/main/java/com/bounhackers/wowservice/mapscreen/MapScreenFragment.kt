package com.bounhackers.wowservice.mapscreen


import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment

import com.bounhackers.wowservice.R
import com.bounhackers.wowservice.appservice.schemas.Vehicle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_map_screen.*

class MapScreenFragment : Fragment(), MapScreenContract.View {

    private var presenter: MapScreenContract.Presenter? = null
    private var onChangeScreenRequestedListener: OnChangeScreenRequestedListener? = null
    private var map: GoogleMap? = null
    private var carMarker: Marker? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setPresenter(MapScreenPresenter(this))
        return inflater.inflate(R.layout.fragment_map_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        val fragment: Fragment? = childFragmentManager.findFragmentById(R.id.mapscreen_fragment_map)
        (fragment as SupportMapFragment?)?.getMapAsync {
            map = it
            map?.moveCamera(CameraUpdateFactory.zoomTo(10.0f))
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is OnChangeScreenRequestedListener) {
            onChangeScreenRequestedListener = context
        } else {
            throw RuntimeException("Context != OnChangeScreenRequestedListener")
        }
    }

    override fun onResume() {
        super.onResume()
        presenter?.subscribe()
    }

    override fun onPause() {
        super.onPause()
        presenter?.unsubscribe()
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.map_screen_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.action_kid_list) {
            onChangeScreenRequestedListener?.onKidListActionClicked()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun displayVehicleLocation(location: Vehicle.Location) {
        val latLng = LatLng(location.latitude.value, location.longitude.value)
        carMarker?.remove()
        map?.moveCamera(CameraUpdateFactory.newLatLng(latLng))

        carMarker = map?.addMarker(MarkerOptions().position(latLng))
    }

    fun setPresenter(presenter: MapScreenContract.Presenter) {
        this.presenter = presenter
    }

    interface OnChangeScreenRequestedListener {
        fun onKidListActionClicked()
    }

    companion object {
        fun newInstance(): MapScreenFragment {
            return MapScreenFragment()
        }
    }

}
