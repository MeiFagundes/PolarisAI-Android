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
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL

class HomeFragment : Fragment() {

    private val messages = mutableListOf(
        Message("Hello there, I'm Polaris! If you want me to help with anything, you only need to ask!",  2),
        Message(
"""Try saying:
    - What’s your name?
    - Who are you?
    - What do you do?
    - Tell me a joke
    - How are you?
    - Do you know Siri?
    - Say something funny
    - What do you like to do?"""
                .trimMargin(),  2)
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

        layout_chatbox.bringToFront()
        separator.bringToFront()

        this.chat_send_btn.setOnClickListener {
            setResponse()
        }

        message_list.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = MessageListAdapter(messages)
        }
    }

    private fun setResponse(){
        messages.add(Message(chat_input_txtInput.text.toString(),  1))

        showProgressBar()

        doAsync {
            val response = URL("https://polarisai.azurewebsites.net/query/${chat_input_txtInput.text}").readText()
            val json = JSONObject(response)
            uiThread {
                messages.add(Message(json["response"].toString(),  2))
                message_list.smoothScrollToPosition((message_list.adapter?.itemCount ?: -1))

                hideProgressBar()
            }
        }
    }

    private fun showProgressBar(){
        chat_send_btn.visibility = View.GONE
        chat_progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        chat_progressBar.visibility = View.GONE
        chat_send_btn.visibility = View.VISIBLE
    }
}