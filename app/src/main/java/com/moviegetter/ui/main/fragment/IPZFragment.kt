package com.moviegetter.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.moviegetter.R
import com.moviegetter.base.MGBaseFragment
import com.moviegetter.crawl.ipz.IPZItem
import com.moviegetter.ui.main.activity.IPZActivity
import com.moviegetter.ui.main.adapter.IPZListAdapter
import com.moviegetter.ui.main.pv.IPZPresenter
import kotlinx.android.synthetic.main.frg_main.view.*

/**
 *Created by Aramis
 *Date:2018/6/27
 *Description:
 */
abstract class IPZFragment : MGBaseFragment() {
    private val dataList = mutableListOf<IPZItem>()
    private val adapter = IPZListAdapter(dataList)
    private var position = 0
    private var presenter:IPZPresenter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        position = getPosition()
        presenter=if(activity is IPZActivity) (activity as IPZActivity).getPresenter() as? IPZPresenter  else null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater.inflate(R.layout.frg_main, null)
        initView()
        setListener()
        return mRootView
    }

    private fun setListener() {
        mRootView.list_result.adapter = adapter
    }

    private fun initView() {

    }

    abstract fun getPosition(): Int
}