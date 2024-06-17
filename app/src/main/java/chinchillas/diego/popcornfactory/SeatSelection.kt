package chinchillas.diego.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val title : TextView = findViewById(R.id.titleSeats)
        var posMovie = -1
        var image = 0
        var idSeat = 0
        val bundle = intent.extras

        if (bundle!=null){
            title.setText(bundle.getString("name"))
            image = bundle.getInt("image")
            posMovie = bundle.getInt("id")
        }

        val confirm : Button = findViewById(R.id.confirm_button)

        confirm.setOnClickListener{
            //TODO añadir logica para reservar el lugar seleccionado por el ususario
            //Hacer una nueva actividad donde se vea el resumen de la compra es decir que se agregue el nombre del cliente y se vea el asiento que se selecciono

            val intent : Intent = Intent(this, SelectionClient::class.java)

            intent.putExtra("name_movie", title.text.toString())
            intent.putExtra("id_seat", idSeat.toString())
            intent.putExtra("image", image)

            this.startActivity(intent)
        }

        val row1 : RadioGroup = findViewById(R.id.row1)
        val row2 : RadioGroup = findViewById(R.id.row2)
        val row3 : RadioGroup = findViewById(R.id.row3)
        val row4 : RadioGroup = findViewById(R.id.row4)

        row1.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                row1.check(checkedId)
                idSeat = checkedId
            }
        }

        row2.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                row2.check(checkedId)
                idSeat = checkedId
            }
        }

        row3.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                row1.clearCheck()
                row2.clearCheck()
                row4.clearCheck()
                row3.check(checkedId)
                idSeat = checkedId
            }
        }

        row4.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1) {
                row1.clearCheck()
                row2.clearCheck()
                row3.clearCheck()
                row4.check(checkedId)
                idSeat = checkedId
            }
        }

    }
}