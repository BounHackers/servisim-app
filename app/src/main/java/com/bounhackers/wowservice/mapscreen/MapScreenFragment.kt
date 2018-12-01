package com.bounhackers.wowservice.mapscreen


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bounhackers.wowservice.R

class MapScreenFragment : Fragment(), MapScreenContract.View {

    private var presenter: MapScreenContract.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map_screen, container, false)
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
