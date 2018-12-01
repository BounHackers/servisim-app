package com.bounhackers.wowservice.register


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bounhackers.wowservice.R

class RegisterFragment : Fragment(), RegisterContract.View {

    private var presenter: RegisterContract.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setPresenter(RegisterPresenter(this))

        return TextView(activity).apply {
            setText(R.string.hello_blank_fragment)
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

    private fun setPresenter(presenter: RegisterContract.Presenter) {
        this.presenter = presenter
    }

    companion object {
        fun newInstance(): RegisterFragment {
            return RegisterFragment()
        }
    }


}
