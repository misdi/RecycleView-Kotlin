package id.skysoft.kotlin.recycleview.recycleviewapps

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val getIntent = intent.extras
        nameResult.text = "This is your name : "+getIntent.get("name").toString()
        ageResult.text = getIntent.get("age").toString()

    }
}
