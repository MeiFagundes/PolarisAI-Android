package com.meifagundes.polarisai

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.meifagundes.polarisai.model.Message

class MessageHolder(inflater: LayoutInflater, parent: ViewGroup, fromUser: Boolean) :
    RecyclerView.ViewHolder(
        if (fromUser) inflater.inflate(R.layout.message_sent_bubble, parent, false)
        else inflater.inflate(R.layout.message_received_bubble, parent, false)) {

    private var messageText: TextView? = null
    private var timeText: TextView? = null

    init {
        messageText = itemView.findViewById(R.id.message_body_txt)
        timeText = itemView.findViewById(R.id.message_time_txt)
    }

    fun bind(message : Message){
        messageText?.text = message.message
        timeText?.text = message.timestamp
    }
}