package googlecodelabs.droidcafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.TextView

class OrderActivity : AppCompatActivity() {

    lateinit var orderTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        orderTextView = findViewById(R.id.order_text_view)

        val intent = intent
        val orderMessageArray = intent.getStringArrayExtra(EXTRA_ORDER_MESSAGE)

        if(orderMessageArray?.isEmpty() == true){
            orderTextView.text = "No orders yet"
        }
        else{
            var orderTextBody = ""
            orderMessageArray?.forEach {
                orderTextBody = orderTextBody + it + "\n"
            }

            orderTextView.text = orderTextBody
        }
    }
}