package br.senai.sp.jandira.bmicompose.utils

import br.senai.sp.jandira.bmicompose.R

fun textBmiLabel (bmiValue: Double): Int {
    if(bmiValue <= 18.5) return R.string.underweight
    if(bmiValue > 18.5 && bmiValue < 25.0)return R.string.normal
    if(bmiValue >= 25.0 && bmiValue < 30.0)return R.string.overweight
    if(bmiValue >= 30.0 && bmiValue < 35.0) return R.string.obese
    if(bmiValue >= 35.0)return R.string.extremely_obese
    else return 0
}