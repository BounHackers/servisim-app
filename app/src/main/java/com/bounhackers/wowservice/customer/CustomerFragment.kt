package com.bounhackers.wowservice.customer


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bounhackers.wowservice.R

class CustomerFragment : Fragment(), CustomerContract.View {

    private var presenter: CustomerPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer, container, false)
    }

    fun setPresenter(presenter: CustomerPresenter) {
        this.presenter = presenter
    }

}
