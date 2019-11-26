package com.meifagundes.polarisai

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.meifagundes.polarisai.model.Message
import android.view.LayoutInflater
import android.view.View


public class MessageListAdapter(private val messages : List<Message>) : RecyclerView.Adapter<MessageHolder>() {
    private val VIEW_TYPE_MESSAGE_SENT = 1
    private val VIEW_TYPE_MESSAGE_RECEIVED = 2

    init {
        println("zopzap")
    }

    override fun getItemCount(): Int = messages.size

    override fun getItemViewType(position: Int): Int {

        if (messages[position].userId == VIEW_TYPE_MESSAGE_SENT)
            return VIEW_TYPE_MESSAGE_SENT
        else
            return VIEW_TYPE_MESSAGE_RECEIVED
    }

    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        println("inside MLA onCreateViewHolder")
        val message: Message = messages[position]
        holder.bind(message)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageHolder {

        println("inside MLA onCreateViewHolder")
        val inflater = LayoutInflater.from(parent.context)

        if (viewType === VIEW_TYPE_MESSAGE_SENT)
            return MessageHolder(inflater, parent, true)
        else /*if (viewType === VIEW_TYPE_MESSAGE_RECEIVED)*/
            return MessageHolder(inflater, parent, false)

    }
}