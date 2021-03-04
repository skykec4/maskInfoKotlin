package com.example.maskinfokotlin

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.maskinfokotlin.databinding.ItemStoreBinding
import com.example.maskinfokotlin.model.Store
import java.util.*

//아이템 뷰의 정보를 가지고 있는 클래스
class StoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding = ItemStoreBinding.bind(itemView)
}

class StoreAdapter : RecyclerView.Adapter<StoreViewHolder>() {
    private var mItems: List<Store> = ArrayList<Store>()
    private val TAG = "StoreAdapter"

    fun updateItems(items: List<Store>) {

        mItems = items
        Log.d("StoreAdapter : ", "updateItems: $mItems")
        notifyDataSetChanged()
        Log.d("StoreAdapter : ", "updateItems: $mItems")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_store, parent, false)
        Log.d(TAG, "onCreateViewHolder: 생성")
        return StoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        holder.binding.store = mItems[position]

    }

    override fun getItemCount(): Int = mItems.size

}

@BindingAdapter("remainStat")
fun setRemainStat(textView: TextView, store: Store) = when (store.remainStat) {
    "plenty" -> textView.text = "충분"
    "some" -> textView.text = "여유"
    "few" -> textView.text = "매진 임박"
    else -> textView.text = "재고 없음"
}

@BindingAdapter("count")
fun setCount(textView: TextView, store: Store) = when (store.remainStat) {
    "plenty" -> textView.text = "100개 이상"
    "some" -> textView.text = "30개 이상"
    "few" -> textView.text = "2개 이상"
    else -> textView.text = "1개 이하"
}

@BindingAdapter("color")
fun setColor(textView: TextView, store: Store) = when (store.remainStat) {
    "plenty" -> textView.setTextColor(Color.GREEN)
    "some" -> textView.setTextColor(Color.YELLOW)
    "few" -> textView.setTextColor(Color.RED)
    else -> textView.setTextColor(Color.GRAY)
}