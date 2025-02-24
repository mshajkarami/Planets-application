package ir.hajkarami.planetsapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import ir.hajkarami.planetsapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var planetsArrayList: ArrayList<Planets>
    private lateinit var adapter: MyCustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        planetsArrayList = arrayListOf(
            Planets("Mercury", "0 Moons", R.drawable.mercury),
            Planets("Venus", "0 Moons", R.drawable.venus),
            Planets("Earth", "1 Moon", R.drawable.earth),
            Planets("Mars", "2 Moons", R.drawable.mars),
            Planets("Jupiter", "79 Moons", R.drawable.jupiter),
            Planets("Saturn", "83 Moons", R.drawable.saturn),
            Planets("Uranus", "27 Moons", R.drawable.uranus),
            Planets("Neptune", "14 Moons", R.drawable.neptune)
        )

        adapter = MyCustomAdapter(this, planetsArrayList)
        binding.planetListView.adapter = adapter

        binding.planetListView.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                this,
                "Planet Name: ${adapter.getItem(position)?.planetsName}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
