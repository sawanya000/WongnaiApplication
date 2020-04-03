package com.egco428.wongnaiapplication

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val clientServer by lazy { RetrofitClient.instance }
    var Data = arrayListOf<Coins>()
    lateinit var adapter: RecyclerDetailAdapter
    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        // load data use api
        loadData()
        // set pull to refresh
        setSwipeRefreshLayout()
        // set Text changed listener
        setSearchText()
    }

    private fun setSearchText() {
        search_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // filter word from search box
                val dataFilter = Data.filter {
                    it.name.toLowerCase().contains(p0.toString().toLowerCase())
                } as ArrayList<Coins>
                setRecyclerAdapter(dataFilter)
            }

        })
    }

    private fun setSwipeRefreshLayout() {
        swipe_refresh_layout.setOnRefreshListener {
            loadData()
        }
    }

    @SuppressLint("CheckResult")
    private fun loadData() {
        // load data from api by use retrofit
        clientServer.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    Data = result.data.coins
                    Log.v("POSTED ARTICLE", "" + result)
                    setRecyclerAdapter(Data)
                    swipe_refresh_layout.isRefreshing = false
                },
                { error ->
                    Log.e("ERROR", error.message)
                }
            )
    }

    private fun setRecyclerAdapter(data: ArrayList<Coins>) {
        // set data list
        val linearLayoutManager = LinearLayoutManager(
            baseContext,
            LinearLayoutManager.VERTICAL, false
        )
        list_coins.layoutManager = linearLayoutManager
        adapter =
            RecyclerDetailAdapter(
                data,
                context
            )
        list_coins.adapter = adapter
    }

}
