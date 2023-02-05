package googlecodelabs.droidcafe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.apply{
            setImageResource(R.drawable.ic_shopping_cart)
            setOnClickListener {
                val intent = Intent(context, OrderActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun showDonutOrder(view: View) {
        displayToast(getString(R.string.donut_order_message))
    }
    fun showIceCreamOrder(view: View) {
        displayToast(getString(R.string.ice_cream_order_message))
    }
    fun showFroyoOrder(view: View) {
        displayToast(getString(R.string.froyo_order_message))
    }

    private fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}