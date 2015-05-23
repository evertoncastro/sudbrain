package com.fatecalc.calculadora;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.*;


public class Calculadora extends Activity {
	
	EditText etNum1, etNum2, etResultado;
	double num1, num2, resultado;
	Button btnsomar, btnsubtrair, btnmultiplicar, btndividir;	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        etNum1= (EditText) findViewById(R.string.numero1);
        etNum2= (EditText) findViewById(R.string.numero2);
        btnsomar= (Button) findViewById(R.string.btnSomar);
        btnsubtrair= (Button) findViewById(R.string.btnSubtrair);
        btnmultiplicar= (Button) findViewById(R.string.btnMultiplicar);
        btndividir= (Button) findViewById(R.string.btnDividir);
        
        etResultado= (EditText) findViewById(R.string.resultado);
        
        btnsomar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				num1=Double.parseDouble(etNum1.getText().toString());
				num2=Double.parseDouble(etNum2.getText().toString());
				resultado=num1+num2;
				etResultado.setText(String.valueOf(resultado));
				
			}
        });
        
        btnsubtrair.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				num1=Double.parseDouble(etNum1.getText().toString());
				num2=Double.parseDouble(etNum2.getText().toString());
				resultado=num1-num2;
				etResultado.setText(String.valueOf(resultado));
				
			}
        });
        
        btnmultiplicar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				num1=Double.parseDouble(etNum1.getText().toString());
				num2=Double.parseDouble(etNum2.getText().toString());
				resultado=num1*num2;
				etResultado.setText(String.valueOf(resultado));
				
			}
        });

        btndividir.setOnClickListener(new View.OnClickListener() {
	
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			num1=Double.parseDouble(etNum1.getText().toString());
			num2=Double.parseDouble(etNum2.getText().toString());
			resultado=num1/num2;
			etResultado.setText(String.valueOf(resultado));
		
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calculadora, menu);
        return true;
    }
    
}
