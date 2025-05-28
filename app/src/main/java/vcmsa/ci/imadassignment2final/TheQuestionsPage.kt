package vcmsa.ci.imadassignment2final

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TheQuestionsPage : AppCompatActivity() {
var thequestions: TextView? = null
    var theanswer: TextView? = null
    var myradiogroup: RadioGroup? = null
    var nextbutton: Button? = null

var score = 0

    val MyQuestions = arrayOf("The ANC party was formed in 1972.", "Nelson Mandela was the first black president of South Africa",
        "Solomon Mahlangu's death was caused by an asasination", "The Apartheid law was abolished in 1990. ", "Nelson Mandela passed away in 05 December 2013.")

    val Thechoices = arrayOf(arrayOf("True","False"), arrayOf("True","False"),arrayOf("True","False"),arrayOf("True","False"),arrayOf("True","False"))
    var Theanswers = arrayOf(1,0,1,1,0)
    var MyQuestionsIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_the_questions_page)


        thequestions = findViewById<View>(R.id.thequestions) as TextView
        theanswer = findViewById<View>(R.id.theanswer) as TextView
        myradiogroup = findViewById<View>(R.id.myradiogroup) as RadioGroup
        nextbutton = findViewById<View>(R.id.nextbutton) as Button

        MyQuestionsView()

        nextbutton!!.setOnClickListener {
            val MySelectedID = myradiogroup!!.checkedRadioButtonId
            if (MySelectedID != -1){

            val MySelectedRadioID = findViewById<RadioButton>(MySelectedID)
                val MySelectedAnswerIndex = myradiogroup!!.indexOfChild(MySelectedRadioID)

            if (MySelectedAnswerIndex == Theanswers[MyQuestionsIndex]){
                score++
                theanswer!!.text = "Correct"
            }
            else{
                theanswer!!.text = "Incorrect"
            }
            MyQuestionsIndex++}
            if (MyQuestionsIndex < MyQuestions.size){
                MyQuestionsView()
            }
            else {
                val intent = Intent(this, Theresults::class.java)
                intent.putExtra("your score", score)
                intent.putExtra("questions", MyQuestions)
                intent.putExtra("the answers", Theanswers)
                startActivity(intent)
                finish()

            }


        }







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun MyQuestionsView(){
       thequestions!!.text = MyQuestions[MyQuestionsIndex]
        myradiogroup!!.removeAllViews()

        for (yourchoices in Thechoices[MyQuestionsIndex]){
            var radioButton = RadioButton(this)
            radioButton.text = yourchoices
            myradiogroup!!.addView(radioButton)
        }





    }
}