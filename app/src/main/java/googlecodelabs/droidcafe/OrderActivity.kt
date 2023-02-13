package googlecodelabs.droidcafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.*

class OrderActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

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

        val spinner : Spinner = findViewById(R.id.phone_label_spinner)

        val arrayAdapter : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(
            this,
            R.array.phone_labels_array,
            android.R.layout.simple_spinner_item)

        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner?.apply{
            onItemSelectedListener = this@OrderActivity
            adapter = arrayAdapter
        }
    }

    fun onRadioButtonClicked(view: View) {
        val checked:Boolean = (view as RadioButton).isChecked
        when(view.id){
            R.id.sameday_radio_button -> if (checked) displayToast(getString(R.string.same_day_messenger_service))
            R.id.nextday_radio_button -> if (checked) displayToast(getString(R.string.next_day_ground_delivery))
            R.id.pickup_radio_button -> if (checked) displayToast(getString(R.string.pick_up))
        }
    }
    private fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}