package googlecodelabs.droidcafe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

const val EXTRA_ORDER_MESSAGE :String = "googlecodelabs.droidcafe.extra.ORDER_MESSAGE"

class MainActivity : AppCompatActivity() {

    private var mOrderMessageArray : Array<String> = arrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null){
            mOrderMessageArray = savedInstanceState.getStringArray("mOrderMessageArray") as Array<String>
        }

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.apply{
            setImageResource(R.drawable.ic_shopping_cart)
            setOnClickListener {
                val intent = Intent(context, OrderActivity::class.java)
                intent.putExtra(EXTRA_ORDER_MESSAGE, mOrderMessageArray)
                startActivity(intent)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if(!mOrderMessageArray.isEmpty()){
           outState.putStringArray("mOrderMessageArray", mOrderMessageArray)
        }
    }

    fun showOrder(view: View) {
        val orderMessage = when(view.id){
            R.id.donut -> getString(R.string.donut_order_message)
            R.id.ice_cream -> getString(R.string.ice_cream_order_message)
            R.id.froyo -> getString(R.string.froyo_order_message)
            else -> {
                throw Exception("cannot get order message")
                return
            }
        }

        mOrderMessageArray = mOrderMessageArray.plus(orderMessage)
        displayToast(orderMessage)
    }

    private fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}