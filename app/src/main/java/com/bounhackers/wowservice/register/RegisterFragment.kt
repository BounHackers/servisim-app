package com.bounhackers.wowservice.register


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bounhackers.wowservice.R
import kotlinx.android.synthetic.main.fragment_register.*

class RegisterFragment : Fragment(), RegisterContract.View {

    private var presenter: RegisterContract.Presenter? = null
    private var onChangeScreenRequestListener: OnChangeScreenRequestListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setPresenter(RegisterPresenter(this))

        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        register_button_back.setOnClickListener {
            onChangeScreenRequestListener?.onRegisterBackPressed()
        }

        register_button_register.setOnClickListener {
            TODO("presenter method not bound")
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is OnChangeScreenRequestListener) {
            onChangeScreenRequestListener = context
        } else {
            throw RuntimeException("Application != OnChangeScreenRequestListener")
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

    interface OnChangeScreenRequestListener {
        fun onRegisterBackPressed()
        fun onRegisterSuccessful()
    }

    companion object {
        fun newInstance(): RegisterFragment {
            return RegisterFragment()
        }
    }


}
