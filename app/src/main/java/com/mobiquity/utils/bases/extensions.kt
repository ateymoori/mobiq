package com.mobiquity.utils.bases

import org.mockito.Mockito

fun <T : androidx.recyclerview.widget.RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
    itemView.setOnClickListener {
        event.invoke(adapterPosition, itemViewType)
    }
    return this
}


inline fun <reified T> mock(): T = Mockito.mock(T::class.java)