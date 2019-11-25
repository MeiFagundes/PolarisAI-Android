package com.meifagundes.polarisai.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.meifagundes.polarisai.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        println("z")
        this.sendBtn.setOnClickListener {
            setResponse()
        }
    }

    private fun setResponse(){
        responseTxt.text = "Awaiting response..."
        doAsync {
            val response = URL("https://polarisai.azurewebsites.net/query/${queryTxt.text}").readText()
            val json = JSONObject(response)
            uiThread {
                responseTxt.text = json["response"].toString()
            }
        }
    }
}