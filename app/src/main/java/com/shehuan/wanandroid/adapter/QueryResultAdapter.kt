package com.shehuan.wanandroid.adapter

import android.content.Context
import android.text.Html
import android.view.View
import android.widget.TextView
import com.othershe.baseadapter.ViewHolder
import com.othershe.baseadapter.base.CommonBaseAdapter
import com.shehuan.wanandroid.R
import com.shehuan.wanandroid.bean.query.DatasItem

class QueryResultAdapter(context: Context?, data: List<DatasItem>?, isOpenLoadMore: Boolean) :
        CommonBaseAdapter<DatasItem>(context, data, isOpenLoadMore) {
    override fun getItemLayoutId(): Int {
        return R.layout.rv_item_article_layout
    }

    override fun convert(viewHolder: ViewHolder, data: DatasItem, position: Int) {
        with(viewHolder) {
            setText(R.id.articleTitleTv, Html.fromHtml(data.title).toString())
            getView<TextView>(R.id.articleTypeTv).run {
                if (data.tags.isNotEmpty()) {
                    text = data.tags[0].name
                    visibility = View.VISIBLE
                } else {
                    visibility = View.GONE
                }
            }
            setText(R.id.articleAuthorTv, data.author)
            setText(R.id.articleTimeTv, data.niceDate)
        }
    }
}