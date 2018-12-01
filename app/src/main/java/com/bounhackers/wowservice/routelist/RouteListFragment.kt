package com.bounhackers.wowservice.routelist


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bounhackers.wowservice.R

class RouteListFragment : Fragment(), RouteListContract.View {

    private var presenter: RouteListContract.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.setPresenter(RouteListPresenter(this))

        return inflater.inflate(R.layout.fragment_route_list, container, false)
    }

    override fun onResume() {
        super.onResume()
        presenter?.subscribe()
    }

    override fun onPause() {
        super.onPause()
        presenter?.unsubscribe()
    }

    fun setPresenter(presenter: RouteListContract.Presenter) {
        this.presenter = presenter
    }


}
