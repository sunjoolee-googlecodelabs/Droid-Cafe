package googlecodelabs.droidcafe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

const val EXTRA_ORDER_MESSAGE :String = "googlecodelabs.droidcafe.extra.ORDER_MESSAGE"

class MainActivity : AppCompatActivity() {

    private var mOrderMessage : String = ""

    private lateinit var donutImageView : ImageView
    private lateinit var icecreamImageView : ImageView
    private lateinit var froyoImageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        donutImageView = findViewById(R.id.donut)
        icecreamImageView = findViewById(R.id.ice_cream)
        froyoImageView = findViewById(R.id.froyo)

        donutImageView.setOnClickListener{
            mOrderMessage = getString(R.string.donut_order_message)
            displayToast(mOrderMessage)
        }
        icecreamImageView.setOnClickListener{
            mOrderMessage = getString(R.string.ice_cream_order_message)
            displayToast(mOrderMessage)
        }
        froyoImageView.setOnClickListener{
            mOrderMessage = getString(R.string.froyo_order_message)
            displayToast(mOrderMessage)
        }

        if(savedInstanceState != null){
            mOrderMessage = savedInstanceState.getString("mOrderMessage") as String
        }

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.apply{
            setImageResource(R.drawable.ic_shopping_cart)
            setOnClickListener {
                val intent = Intent(context, OrderActivity::class.java)
                intent.putExtra(EXTRA_ORDER_MESSAGE, mOrderMessage)
                startActivity(intent)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if(mOrderMessage.isNotBlank()){
           outState.putString("mOrderMessage", mOrderMessage)
        }
    }

    private fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}