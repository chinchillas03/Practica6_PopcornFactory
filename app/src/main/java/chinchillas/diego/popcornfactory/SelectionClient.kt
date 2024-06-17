package chinchillas.diego.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SelectionClient : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection_client)

        val title : TextView = findViewById(R.id.name_movie)
        val seat : RadioButton = findViewById(R.id.seat_client)
        val button_cancel : Button = findViewById(R.id.button_cancel)
        val button_confirm : Button = findViewById(R.id.button_confirm)
        val image : ImageView = findViewById(R.id.imagen)
        val bundle = intent.extras

        if (bundle!=null){
            title.setText(bundle.getString("name_movie"))
            seat.setText(bundle.getString("id_seat"))
            image.setImageResource(bundle.getInt("image"))
        }

        button_cancel.setOnClickListener{
            var intento = Intent(this, SeatSelection::class.java)
            this.startActivity(intento)
        }

        button_confirm.setOnClickListener {
            Toast.makeText(this, "Enjoy de movie", Toast.LENGTH_LONG).show()
            var intento = Intent(this, CatalogActivity::class.java)
            this.startActivity(intento)
        }


    }
}