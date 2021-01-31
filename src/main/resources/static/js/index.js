function calculateBMI() {
    // getting user input
    let height = Number(document.getElementById("u-height").value);
    let height_units = document.getElementById("height-units").value;
    let weight = Number(document.getElementById("u-weight").value);
    let weight_units = document.getElementById("weight-units").value;
    let result = document.getElementById("output");
    let bmi_status = 'N/A';

    //if height or weight is negative
    if (height < 0 || weight < 0) {
        alert('Enter positive values');
        return false;
    }
    //if height or weight is empty
    else if(!height || !weight) {
        alert('Fields cannot be empty');
        return false;
    }


    //Convert all units to metric
    // bmi = mass (in kilograms) / height (in meters)

    //height
    if (height_units === "inches") height /= 39.3700787;
    if (height_units === "cm") height /= 100;

    //weight
    if (weight_units === "lb") weight /= 2.20462;

    //Perform calculation
    let BMI = weight / Math.pow(height, 2);

    //Display result of calculation (upto 2 decimal points)
    let output = (Math.round(BMI * 100) / 100).toFixed(2);

    if (output < 18.5)
        bmi_status = "Underweight";
    else if (output >= 18.5 && output <= 24.9)
        bmi_status = "Normal";
    else if (output >= 25 && output <= 29.9)
        bmi_status = "Overweight";
    else
        bmi_status = "Obese";

    // displaying output in html format and adding some animation
    result.innerHTML = "<span> Your are </span><span class='font-weight-bold'>" + bmi_status + "</span><span> Your BMI is </span><span class='font-weight-bold'>" + output + "</span>";
    $('#output').fadeIn().delay(3000).fadeOut();
}