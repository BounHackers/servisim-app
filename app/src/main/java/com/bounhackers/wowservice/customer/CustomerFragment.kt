package com.bounhackers.wowservice.customer


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bounhackers.wowservice.R

class CustomerFragment : Fragment(), CustomerContract.View {

    private var presenter: CustomerContract.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setPresenter(CustomerPresenter(this))

        return inflater.inflate(R.layout.fragment_customer, container, false)
    }

    private fun setPresenter(presenter: CustomerContract.Presenter) {
        this.presenter = presenter
    }

    override fun onResume() {
        super.onResume()
        presenter?.subscribe()
    }

    override fun onPause() {
        super.onPause()
        presenter?.unsubscribe()
    }

    companion object {
        fun newInstance(): CustomerFragment {
            return CustomerFragment()
        }
    }
}
