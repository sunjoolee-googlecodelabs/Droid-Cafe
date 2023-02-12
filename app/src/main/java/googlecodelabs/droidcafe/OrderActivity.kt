package googlecodelabs.droidcafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.TextView

class OrderActivity : AppCompatActivity() {

    lateinit var orderTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        orderTextView = findViewById(R.id.order_text_view)

        val intent = intent
        val orderMessage = intent.getStringExtra(EXTRA_ORDER_MESSAGE)

        if((orderMessage == null)||(orderMessage?.isBlank() == true)){
            orderTextView.text = "No orders yet"
        }
        else{
            orderTextView.text = orderMessage
        }
    }

    fun onRadioButtonClicked(view: View) {}
}