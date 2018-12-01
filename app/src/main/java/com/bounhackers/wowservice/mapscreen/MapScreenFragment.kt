package com.bounhackers.wowservice.mapscreen


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bounhackers.wowservice.R
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.fragment_map_screen.*

class MapScreenFragment : Fragment(), MapScreenContract.View {

    private var presenter: MapScreenContract.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (mapscreen_fragment_map as SupportMapFragment?)?.getMapAsync {

        }
    }

    fun setPresenter(presenter: MapScreenContract.Presenter) {
        this.presenter = presenter
    }

    companion object {
        fun newInstance(): MapScreenFragment {
            return MapScreenFragment()
        }
    }

}
