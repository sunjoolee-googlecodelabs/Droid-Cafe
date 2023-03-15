package googlecodelabs.droidcafe

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import googlecodelabs.droidcafe.databinding.ActivityMainBinding

const val EXTRA_ORDER_MESSAGE :String = "googlecodelabs.droidcafe.extra.ORDER_MESSAGE"

class MainActivity : AppCompatActivity() {

    private var mOrderMessage : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val donutImageView = findViewById<ImageView>(R.id.donut)
        val iceCreamImageView = findViewById<ImageView>(R.id.ice_cream)
        val froyoImageView = findViewById<ImageView>(R.id.froyo)

        donutImageView.setOnClickListener{
            mOrderMessage = getString(R.string.donut_order_message)
            displayToast(mOrderMessage)
        }
        iceCreamImageView.setOnClickListener{
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
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_settings -> {
                Toast.makeText(this, "settings item clicked", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
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