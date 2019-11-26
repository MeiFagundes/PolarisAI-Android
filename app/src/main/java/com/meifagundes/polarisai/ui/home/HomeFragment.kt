package com.meifagundes.polarisai.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.meifagundes.polarisai.MessageListAdapter
import com.meifagundes.polarisai.R
import com.meifagundes.polarisai.model.Message
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : Fragment() {

    private val messages = listOf(
        Message("Who are you?", Calendar.getInstance(), 1),
        Message("I'm the brightest star in the constellation of Ursa Minor, Polaris!", Calendar.getInstance(), 2)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //homeViewModel =
        //        ViewModelProviders.of(this).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //this.sendBtn.setOnClickListener {
        //    setResponse()
        //}

        message_list.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = MessageListAdapter(messages)
        }

        /*println(activity == null)
        messageRecycler = message_list as RecyclerView
        messageAdapter = activity?.let { MessageListAdapter(it, messages) }
        messageRecycler!!.layoutManager = LinearLayoutManager(activity)*/

    }

    /*private fun setResponse(){
        responseTxt.text = "Awaiting response..."
        doAsync {
            val response = URL("https://polarisai.azurewebsites.net/query/${queryTxt.text}").readText()
            val json = JSONObject(response)
            uiThread {
                responseTxt.text = json["response"].toString()
            }
        }
    }*/
}