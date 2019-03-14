package com.example.postcard.Fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.postcard.Adapter.OptionAdapter
import com.example.postcard.Class.Options

import com.example.postcard.R

class Fragment_questionnaire : Fragment() {

    private val QUES: String = "question"
    private val OPTIONS: String = "options"
    private val FRAGMENT_NUMBER = "id"
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val retView =  inflater.inflate(R.layout.fragment_fragment_questionnaire, container, false)

        val args = arguments
        var optionList : ArrayList<Options> = args!!.getParcelableArrayList<Options>(OPTIONS)
        var question : String = args.getString(QUES)
        var id : Int = args.getInt(FRAGMENT_NUMBER)

        val textView :TextView
        textView = retView.findViewById(R.id.question)
        textView.setText(question)

        recyclerView = retView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        recyclerView.adapter = OptionAdapter(optionList, activity, id)

        return retView
    }

    companion object {

        private val QUES: String = "question"
        private val OPTIONS: String = "options"
        private val FRAGMENT_NUMBER = "id"

        fun newInstance(question: String, options: ArrayList<Options>, id: Int): Fragment_questionnaire {
            val args = Bundle()
            args.putString(QUES, question)
            args.putParcelableArrayList(OPTIONS, options)
            args.putInt(FRAGMENT_NUMBER, id)
            val fragment = Fragment_questionnaire()
            fragment.arguments = args
            return fragment
        }
    }

}
