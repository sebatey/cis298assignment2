package edu.kvcc.cis298.cis298assignment2;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TemperatureConverter extends AppCompatActivity {

    private Converter mConverter;

    private EditText mInputEditText;

    private RadioGroup mFromGroup;
    private RadioGroup mToGroup;

    private RadioButton mFromCelsiusRadioButton;
    private RadioButton mFromFahrenheitRadioButton;
    private RadioButton mFromKelvinRadioButton;
    private RadioButton mFromRankineRadioButton;
    private RadioButton mToCelsiusRadioButton;
    private RadioButton mToFahrenheitRadioButton;
    private RadioButton mToKelvinRadioButton;
    private RadioButton mToRankineRadioButton;

    private int mFrom;
    private int mTo;

    private Button mConvertButton;

    private TextView mSolutionTextView;
    private TextView mFormulaTextView;

    private String mSolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);

        //initialize variables
        mConverter = new Converter();

        mInputEditText = (EditText) findViewById(R.id.edit_text_input);

        mFromGroup = (RadioGroup) findViewById(R.id.from_radio_group);
        mToGroup = (RadioGroup) findViewById(R.id.to_radio_group);

        mFromCelsiusRadioButton = (RadioButton) findViewById(R.id.from_celsius_radio_button);
        mFromFahrenheitRadioButton = (RadioButton) findViewById(R.id.from_fahrenheit_radio_button);
        mFromKelvinRadioButton = (RadioButton) findViewById(R.id.from_kelvin_radio_button);
        mFromRankineRadioButton = (RadioButton) findViewById(R.id.from_rankine_radio_button);
        mToCelsiusRadioButton = (RadioButton) findViewById(R.id.to_celsius_radio_button);
        mToFahrenheitRadioButton = (RadioButton) findViewById(R.id.to_fahrenheit_radio_button);
        mToKelvinRadioButton = (RadioButton) findViewById(R.id.to_kelvin_radio_button);
        mToRankineRadioButton = (RadioButton) findViewById(R.id.to_rankine_radio_button);

        mConvertButton = (Button) findViewById(R.id.convert_button);

        mSolutionTextView = (TextView) findViewById(R.id.solution_text_view);
        mFormulaTextView = (TextView) findViewById(R.id.formula_text_view);

        mFrom = 0;
        mTo = 0;

        mConvertButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                mFrom = mFromGroup.getCheckedRadioButtonId();
                mTo = mToGroup.getCheckedRadioButtonId();
                Log.i("From", String.valueOf(mFrom));
                Log.i("To", String.valueOf(mTo));
                mSolution = mConverter.calculate(mInputEditText.getText().toString(),mFrom,mTo);
                if (mSolution == "x") {
                    mSolutionTextView.setText(mInputEditText.getText());
                }else{
                    mSolutionTextView.setText(mSolution);
                }
            }
        });

        mFromGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mFrom = checkedId;
                updateFormula(mFrom, mTo);
            }
        });

        mToGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                mTo = checkedId;
                updateFormula(mFrom, mTo);
            }
        });

    }

    private void updateFormula(int from, int to){
        switch (from) {
            case 2131492943:
                switch (to) {
                    case 2131492948:
                        mFormulaTextView.setText("C = C");
                        break;
                    case 2131492949:
                        mFormulaTextView.setText(R.string.c_to_f);
                        break;
                    case 2131492950:
                        mFormulaTextView.setText(R.string.c_to_k);
                        break;
                    case 2131492951:
                        mFormulaTextView.setText(R.string.c_to_r);
                        break;
                }
                break;
            case 2131492944:
                switch (to) {
                    case 2131492948:
                        mFormulaTextView.setText(R.string.f_to_c);
                        break;
                    case 2131492949:
                        mFormulaTextView.setText("F = F");
                        break;
                    case 2131492950:
                        mFormulaTextView.setText(R.string.f_to_k);
                        break;
                    case 2131492951:
                        mFormulaTextView.setText(R.string.f_to_r);
                        break;
                }
                break;
            case 2131492945:
                switch (to) {
                    case 2131492948:
                        mFormulaTextView.setText(R.string.k_to_c);
                        break;
                    case 2131492949:
                        mFormulaTextView.setText(R.string.k_to_f);
                        break;
                    case 2131492950:
                        mFormulaTextView.setText("K = K");
                        break;
                    case 2131492951:
                        mFormulaTextView.setText(R.string.k_to_r);
                        break;
                }
                break;
            case 2131492946:
                switch (to) {
                    case 2131492948:
                        mFormulaTextView.setText(R.string.r_to_c);
                        break;
                    case 2131492949:
                        mFormulaTextView.setText(R.string.r_to_f);
                        break;
                    case 2131492950:
                        mFormulaTextView.setText(R.string.r_to_k);
                        break;
                    case 2131492951:
                        mFormulaTextView.setText("R = R");
                        break;
                }
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("InputEditText", String.valueOf(mInputEditText.getText()));
        savedInstanceState.putInt("FromRadioButton",mFromGroup.getCheckedRadioButtonId());
        savedInstanceState.putInt("ToRadioButton",mToGroup.getCheckedRadioButtonId());
        savedInstanceState.putString("SolutionText",String.valueOf(mSolutionTextView.getText()));
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        mInputEditText.setText(savedInstanceState.getString("InputEditText"));
        mFromGroup.check(savedInstanceState.getInt("FromRadioButton"));
        mToGroup.check(savedInstanceState.getInt("ToRadioButton"));
        mSolutionTextView.setText(savedInstanceState.getString("SolutionText"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_temperature_converter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
