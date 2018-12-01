package com.bounhackers.wowservice.profileedit


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bounhackers.wowservice.R

class ProfileEditFragment : Fragment(), ProfileEditContract.View {

    private var presenter: ProfileEditContract.Presenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setPresenter(ProfileEditPresenter(this))

        return TextView(activity).apply {
            setText(R.string.hello_blank_fragment)
        }
    }

    private fun setPresenter(presenter: ProfileEditContract.Presenter) {
        this.presenter = presenter
    }


}
