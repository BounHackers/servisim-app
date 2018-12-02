package com.bounhackers.wowservice.customer


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.bounhackers.wowservice.R
import com.bounhackers.wowservice.base.ProgressIndicatorInterface
import com.bounhackers.wowservice.data.Model
import kotlinx.android.synthetic.main.fragment_customer.*

class CustomerFragment : Fragment(), CustomerContract.View {

    private var presenter: CustomerContract.Presenter? = null
    private val kids: ArrayList<Model.Kid> = ArrayList()

    private var adapter: KidListAdapter? = null
    private var progressIndicatorInterface: ProgressIndicatorInterface? = null
    private var onClickChildListener: OnClickChildListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setPresenter(CustomerPresenter(this))
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_customer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = KidListAdapter(kids, view.context)
        adapter?.setOnKidClickListener { onClickChildListener?.onClickChild(it) }

        customer_recyclerview_root.layoutManager = LinearLayoutManager(view.context)
        customer_recyclerview_root.adapter = adapter
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

    override fun fillParentInfo(parent: Model.Parent) {
        customer_textview_name.text = parent.name
        customer_textview_location.text = parent.location
    }

    override fun fillKids(kids: List<Model.Kid>) {
        this.kids.clear()
        this.kids.addAll(kids)
        adapter?.notifyDataSetChanged()
    }

    override fun addChildSuccessful(kid: Model.Kid) {
        this.kids.add(kid)
        adapter?.notifyItemInserted(this.kids.size - 1)
    }

    override fun showProgress() {
        progressIndicatorInterface?.showProgress()
    }

    override fun hideProgress() {
        progressIndicatorInterface?.hideProgress()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is ProgressIndicatorInterface) {
            progressIndicatorInterface = context
        }
        if(context is OnClickChildListener) {
            onClickChildListener = context
        } else {
            throw RuntimeException("Context != OnClickChildListener")
        }
    }

    interface OnClickChildListener {
        fun onClickChild(kid: Model.Kid)
    }

    companion object {
        fun newInstance(): CustomerFragment {
            return CustomerFragment()
        }
    }
}
