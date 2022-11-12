package com.example.my_jetpack

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Black
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.my_jetpack.ui.theme.latofamily
import com.example.my_jetpack.ui.theme.robotofamily

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)
//        val composeview = findViewById<ComposeView>(R.id.composeview1)

        setContent {

//            val (pinValue,onPinValueChange) = remember{
//                mutableStateOf("")
//            }
//
//            Surface(color = MaterialTheme.colors.background) {
//                PinView(pinText =pinValue , onPinTextChange = onPinValueChange, type = Companion.PIN_VIEW_TYPE_BORDER)
//            }
///
//            EnterOtpDialog(mobileNumber = "9022653325")
            AddaLoginStuff()
        }

    }
    @SuppressLint("UnrememberedMutableState")
    @Composable
    fun AddaLoginStuff()
    {
        ProvideMobile(userName = "vaibhav", mutableStateOf(""), mutableStateOf(true))

    }


    enum class CustomDialogPosition {
        BOTTOM, TOP
    }

    fun Modifier.customDialogModifier(pos: CustomDialogPosition) =
        layout { measurable, constraints ->

            val placeable = measurable.measure(constraints)
            layout(constraints.maxWidth, constraints.maxHeight) {
                when (pos) {
                    CustomDialogPosition.BOTTOM -> {
                        placeable.place(0, constraints.maxHeight - placeable.height, 10f)
                    }
                    CustomDialogPosition.TOP -> {
                        placeable.place(0, 90, 10f)
                    }
                }
            }
        }


    @Composable
    fun EnterOtpDialog(mobileNumber: String, otpEntered: MutableState<String>, invalid: MutableState<Boolean>){

        if(invalid.value) {
            Card(
                modifier = Modifier
                    .wrapContentSize()
            )
            {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.wrapContentSize())
                {
                    Image(
                        painter = painterResource(id = R.drawable.ic_cross),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(21.dp)
                            .align(alignment = Alignment.TopEnd)
                            .pointerInput("") {
                                detectTapGestures(onTap = {
                                    invalid.value = false
                                }
                                )
                            }
                    )

                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {

                        Text(
                            text = "Enter OTP", style = TextStyle(
                                fontSize = 18.sp, fontFamily = robotofamily, color = colorResource(
                                    id = R.color.signUp
                                )
                            ),
                            modifier = Modifier.padding(top = 40.dp)
                        )

                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 54.dp)
                        )
                        {
                            Text(
                                modifier = Modifier.padding(top = 12.dp),
                                text = buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(
                                            color = colorResource(
                                                id = R.color.signUp_subtitle
                                            ),
                                            fontSize = 14.sp, fontFamily = latofamily
                                        )
                                    ) {
                                        append("Please enter the OTP sent to $mobileNumber ? ")
                                    }
                                    withStyle(
                                        style = SpanStyle(
                                            color = colorResource(id = R.color.active),
                                            fontSize = 14.sp,
                                            fontFamily = latofamily
                                        )
                                    ) {
                                        append("Edit Number")
                                    }
                                },
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = latofamily,
                                    color = colorResource(
                                        id = R.color.signUp_subtitle
                                    )
                                )
                            )
//                        Text(
//                            text = "Edit Number", style = TextStyle(
//                                color = colorResource(id = R.color.active), fontSize = 14.sp,
//                                fontFamily = latofamily
//                            )
//                        )

                        }
                        Box(modifier = Modifier.padding(top = 25.dp))
                        {
                            PinView(pinText = otpEntered.value, onPinTextChange = {
                                if (it.length <= 6) {
                                    otpEntered.value = it
                                }
                            }, digitCount = 6, type = Companion.PIN_VIEW_TYPE_BORDER)
                        }

                        Text(
                            maxLines = 1,
                            text = "Did not receive OTP?",
                            style = TextStyle(
                                color = colorResource(id = R.color.caption),
                                fontSize = 15.sp,
                                fontWeight = FontWeight(400),
                                fontFamily = latofamily
                            ),
                            modifier = Modifier.padding(top = 40.dp)
                        )


                        Button(
                            modifier = Modifier
                                .padding(top = 12.dp, bottom = 30.dp),
                            onClick = { /*TODO*/ },
                            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.active))

                        )
                        {
                            Text(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                                text = "Resend OTP",
                                style = TextStyle(
                                    color = colorResource(id = R.color.white),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight(500),
                                    fontFamily = latofamily
                                )
                            )
                        }

                    }
                }


            }
        }


    }

    @SuppressLint("UnrememberedMutableState")
    @Composable
  fun ProvideMobile(userName : String ,mobileNumber: MutableState<String> ,isvalid : MutableState<Boolean>)
  {
      Box(modifier = Modifier
          .fillMaxSize()
          .background(color = colorResource(id = R.color.white)))
      {
          Image(painter = painterResource(id = R.drawable.ic_cross),
                contentDescription = null , modifier = Modifier
                  .align(alignment = Alignment.TopStart)
                  .padding(start = 22.dp, top = 22.dp))

          OutlinedButton(onClick = { /*TODO*/ },

                border = BorderStroke(1.dp , color =colorResource(id = R.color.active) )
                , modifier = Modifier
                  .align(alignment = Alignment.TopEnd)
                  .padding(top = 11.dp, end = 16.dp))
          {
              Text(
                  text = "SKIP", color = colorResource(id = R.color.active),
                  style = TextStyle(
                      fontSize = 12.sp, fontFamily = latofamily,
                      fontWeight = FontWeight(700)
                  ),
              )


          }

          Column(modifier = Modifier
              .padding(top = 60.dp, start = 16.dp, end = 16.dp)
              .fillMaxWidth())
          {
              Text(text ="Hi $userName" ,  style = TextStyle(fontSize  =18.sp , fontFamily = robotofamily , fontWeight = FontWeight(500)))

              Text(modifier = Modifier.padding(top=10.dp),text ="Provide your mobile number to complete your profile",
                style= TextStyle(fontSize = 14.sp,color = colorResource(id = R.color.signUp_subtitle) ,  fontFamily = latofamily , fontWeight =FontWeight(400) )
               )
              Box(
                  modifier = Modifier
                      .fillMaxWidth()
                      .padding(top = 34.dp),
                  contentAlignment = Alignment.TopStart
              )
              {
                  Text(
                      text = "Email / Mobile No.", fontFamily = latofamily, style = TextStyle(
                          color = colorResource(
                              id = R.color.mobileText
                          ), fontSize = 14.sp, fontWeight = FontWeight(400)
                      )
                  )
              }

              Spacer(modifier = Modifier.height(6.dp))
              OutlinedTextField(
                  modifier = Modifier
                      .height(52.dp)
                      .fillMaxWidth()
                      .border(
                          0.5.dp,
                          color = colorResource(id = R.color.text_f_border),
                          shape = RoundedCornerShape(8.dp)
                      ),
                  singleLine = true,
                  value = mobileNumber.value,
                  keyboardOptions = KeyboardOptions(
                      keyboardType = KeyboardType.Text
                  ),
                  shape = RoundedCornerShape(8.dp),
                  onValueChange = {
                       if(it.length<=10)
                       {
                           mobileNumber.value = it
                       }
                  },
                  placeholder = {
                      Text("10 digits number", style = TextStyle(fontSize = 16.sp))
                  },
                  colors = TextFieldDefaults.outlinedTextFieldColors(
                      focusedBorderColor = colorResource(id = R.color.active),
                      cursorColor = colorResource(id = R.color.active)
                  ),
                  textStyle = TextStyle(
                      fontSize = 16.sp,
                      fontWeight = FontWeight(450),
                      fontFamily = latofamily,
                      textAlign = TextAlign.Start
                  )
              )
              if (!isvalid.value) {
                  Text(
                      textAlign = TextAlign.Start, text = "Please check your contact number ", modifier = Modifier
                          .padding(top = 6.dp)
                          .fillMaxWidth(), style = TextStyle(
                          color = colorResource(
                              id = R.color.active
                          ),
                          fontSize = 10.sp,
                          fontWeight = FontWeight(400),
                          fontFamily = latofamily
                      )
                  )
              }
          }
          Button(onClick = {} ,modifier = Modifier
              .padding(bottom = 40.dp, start = 16.dp, end = 16.dp)
              .fillMaxWidth()
              .height(50.dp)

              .align(alignment = Alignment.BottomCenter) , colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(
              id = R.color.active
          )))
          {
              Text(text = "Continue" ,color= colorResource(id = R.color.white),style = TextStyle(fontSize = 18.sp  , fontWeight =FontWeight(400)  ,
                  fontFamily = latofamily), textAlign = TextAlign.Center
              )
          }
      }

  }



    @SuppressLint("UnrememberedMutableState")
    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun Login() {
        var text by remember {
            mutableStateOf("")
        }

        var pass_visiblity by remember {
            mutableStateOf(false)
        }
        var password by remember {
            mutableStateOf("")
        }
        val maxChar = 10

        var errorText by remember {
            mutableStateOf("")
        }
        var inValidUser by remember {
            mutableStateOf(false)
        }

        val focusManager = LocalFocusManager.current
        val keyboardController = LocalSoftwareKeyboardController.current
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.white))
        )
        {

            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 22.dp)
                    .background(
                        color = colorResource(
                            id = R.color.white
                        )
                    ), horizontalAlignment = Alignment.CenterHorizontally
            )
            {


                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopStart)
                {

                    Image(
                        painter = painterResource(id = R.drawable.ic_cross),
                        modifier = Modifier.padding(start = 2.dp),
                        contentDescription = null,
                    )
                }

                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopStart)
                {
                    Text(
                        text = "Login",
                        modifier = Modifier.padding(top = 4.dp),
                        fontFamily = latofamily,
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = colorResource(id = R.color.signUp),
                            fontWeight = FontWeight(700)
                        )
                    )
                }


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    contentAlignment = Alignment.TopStart
                )
                {
                    Text(
                        text = stringResource(id = R.string.loginsubtitle),
                        fontFamily = latofamily,
                        style = TextStyle(
                            color = colorResource(id = R.color.signUp_subtitle),
                            fontSize = 15.sp, fontWeight = FontWeight(450)
                        ),
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 34.dp),
                    contentAlignment = Alignment.TopStart
                )
                {
                    Text(
                        text = "Email / Mobile No.", fontFamily = latofamily, style = TextStyle(
                            color = colorResource(
                                id = R.color.mobileText
                            ), fontSize = 14.sp, fontWeight = FontWeight(400)
                        )
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .height(54.dp)
                        .fillMaxWidth()
                        .border(
                            0.5.dp,
                            color = colorResource(id = R.color.text_f_border),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    singleLine = true,
                    value = text,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next,
                        keyboardType = KeyboardType.Text
                    ),
                    keyboardActions = KeyboardActions(onNext = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }),
                    shape = RoundedCornerShape(8.dp),
                    onValueChange = {
                        inValidUser = false
                    },
                    placeholder = {
                        Text("10 digits number", style = TextStyle(fontSize = 16.sp))
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.active),
                        cursorColor = colorResource(id = R.color.active)
                    ),
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(450),
                        fontFamily = latofamily
                    )
                )
                if (errorText.isNotEmpty()) {
                    Text(
                        textAlign = TextAlign.Start, text = errorText, modifier = Modifier
                            .padding(top = 10.dp)
                            .fillMaxWidth(), style = TextStyle(
                            color = colorResource(
                                id = R.color.active
                            ),
                            fontSize = 10.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = latofamily
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    contentAlignment = Alignment.TopStart
                )
                {
                    Text(
                        text = "password", fontFamily = latofamily, style = TextStyle(
                            color = colorResource(
                                id = R.color.mobileText
                            ), fontSize = 14.sp, fontWeight = FontWeight(400)
                        )
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .height(54.dp)
                        .fillMaxWidth()
                        .border(
                            0.5.dp,
                            color = colorResource(id = R.color.text_f_border),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    singleLine = true,
                    trailingIcon = {
                        val icon = if (pass_visiblity)
                            Icons.Filled.Visibility
                        else Icons.Filled.VisibilityOff

                        IconButton(onClick = { pass_visiblity = !pass_visiblity }) {
                            Icon(imageVector = icon, contentDescription = null)
                        }
                    },
                    value = password,
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done,
                        keyboardType = KeyboardType.Password
                    ),
                    keyboardActions = KeyboardActions(onDone = {
                        focusManager.clearFocus()
                        keyboardController?.hide()
                    }),
                    shape = RoundedCornerShape(8.dp),
                    onValueChange = { if (it.length <= maxChar) password = it },
                    placeholder = {
                        Text("10 digits number", style = TextStyle(fontSize = 16.sp))
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.active),

                        cursorColor = colorResource(id = R.color.active)
                    ),
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(450),
                        fontFamily = latofamily
                    ),
                    visualTransformation = if (!pass_visiblity) {
                        PasswordVisualTransformation('*')
                    } else {
                        VisualTransformation.None
                    }
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp), contentAlignment = Alignment.CenterEnd
                )
                {
                    Text(
                        text = "Forget Password ?", style = TextStyle(
                            fontFamily = latofamily,
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            color = colorResource(
                                id = R.color.forgot_pass
                            )
                        )
                    )

                }
                Button(
                    onClick = {  inValidUser = true },
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .height(50.dp)
                        .fillMaxWidth()
                            ,
                    elevation = ButtonDefaults.elevation(
                        defaultElevation = 10.dp,
                        pressedElevation = 15.dp,
                        disabledElevation = 0.dp
                    ),
                    colors = ButtonDefaults.buttonColors(backgroundColor =  colorResource(id = R.color.active) )
                )
                {
                        Text(
                            text = "Login",
                            fontFamily = latofamily,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight(400),
                                color = colorResource(
                                    id = R.color.white
                                )
                            ),
                            textAlign = TextAlign.Center
                        )
                }
                Box(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(vertical = 20.dp)
                       ,
                    contentAlignment = Alignment.Center
                )
                {
                    google_button()
                }
                Box(
                    modifier = Modifier.padding(top = 70.dp),
                    contentAlignment = Alignment.Center
                )
                {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        Text(
                            text = "New to Adda247 ? ",

                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = latofamily,
                                fontWeight = FontWeight(400)
                            )
                        )
                        Text(
                            text = "Signup Now", style = TextStyle(
                                fontSize = 14.sp, fontFamily = latofamily, color = colorResource(
                                    id = R.color.active
                                ), fontWeight = FontWeight(400)
                            )
                        )
                    }
                }
            }
            if (inValidUser) {
                Dialog(onDismissRequest = { inValidUser = false })
                {
                    EnterOtpDialog(mobileNumber = "9022653325", mutableStateOf("") , mutableStateOf(inValidUser))
                }

            }
        }
    }



    fun validate(string: String): String {
        if (string.length == 10) {
            for (c in string) {
                if (c.isLetter()) return "Please check your mobile number"
            }
        }
        if (string.length < 10) {
            return "Please check your mobile number"
        }
        if (string.length > 10 && !string.contains("@gmail.com")) {
            return "Please check your email id"
        }
        return ""
    }

    @Composable
    fun SignUp_OTP() {
        var text by remember { mutableStateOf("") }
        val maxChar = 10
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.white))
        )
        {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 22.dp)
                    .background(
                        color = colorResource(
                            id = R.color.white
                        )
                    ), horizontalAlignment = Alignment.CenterHorizontally
            )
            {

                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopStart)
                {

                    Image(
                        painter = painterResource(id = R.drawable.ic_cross),
                        modifier = Modifier.padding(start = 2.dp),
                        contentDescription = null,
                    )
                }
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopStart)
                {
                    Text(
                        text = "Sign Up",
                        modifier = Modifier.padding(top = 4.dp),
                        fontFamily = latofamily,
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = colorResource(id = R.color.signUp),
                            fontWeight = FontWeight(700)
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    contentAlignment = Alignment.TopStart
                )
                {
                    Text(
                        text = stringResource(id = R.string.signupsubtitle),
                        fontFamily = latofamily,
                        style = TextStyle(
                            fontSize = 14.sp, fontWeight = FontWeight(400)
                        ),
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 34.dp),
                    contentAlignment = Alignment.TopStart
                )
                {
                    Text(
                        text = "Mobile No.", fontFamily = latofamily, style = TextStyle(
                            color = colorResource(
                                id = R.color.mobileText
                            ), fontSize = 14.sp, fontWeight = FontWeight(400)
                        )
                    )
                }
                Spacer(modifier = Modifier.height(6.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .height(54.dp)
                        .fillMaxWidth()
                        .border(
                            0.5.dp,
                            color = colorResource(id = R.color.text_f_border),
                            shape = RoundedCornerShape(8.dp)
                        ),
                    singleLine = true,

                    value = text,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    shape = RoundedCornerShape(8.dp),
                    onValueChange = { if (it.length <= maxChar) text = it },
                    placeholder = {
                        Text("10 digits number", style = TextStyle(fontSize = 16.sp))
                    },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.active),
                        cursorColor = colorResource(id = R.color.active)
                    ),
                    textStyle = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(450),
                        fontFamily = latofamily
                    )
                )

                    Button(modifier = Modifier
                        .padding(top = 20.dp)
                        .height(50.dp)
                        .fillMaxWidth(),colors = ButtonDefaults.buttonColors(backgroundColor =colorResource(id = R.color.active)), onClick = {})
                    {

                        Text(
                            text = "Generate OTP",
                            fontFamily = latofamily,
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight(400),
                                color = colorResource(
                                    id = R.color.white
                                )
                            )
                        )
                   }

                Text(
                    modifier = Modifier.padding(vertical = 36.dp),
                    text = "or",
                    style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight(400)),
                    fontFamily = latofamily
                )

                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                        .background(
                            color = colorResource(id = R.color.white)
                        )
                        .border(
                            1.dp,
                            color = colorResource(id = R.color.active),
                            shape = RoundedCornerShape(6.dp)
                        ),

                    contentAlignment = Alignment.Center
                )
                {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        androidx.compose.material3.Text(
                            text = "Already have an account ?",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = colorResource(id = R.color.signtext)
                            )
                        )
                        androidx.compose.material3.Text(
                            text = "Login",
                            style = TextStyle(
                                color = colorResource(id = R.color.active),
                                fontSize = 14.sp,
                                fontWeight = FontWeight(500)
                            ),
                            modifier = Modifier.padding(start = 4.dp)
                        )

                    }
                }
                Box(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(vertical = 20.dp)
                        ,
                    contentAlignment = Alignment.Center
                )
                {
                    google_button()
                }
            }
        }
    }

    @Composable
    fun PinView(
        pinText: String,
        onPinTextChange: (String) -> Unit,
        digitColor: androidx.compose.ui.graphics.Color = colorResource(id = R.color.gglborder),
        digitSize: TextUnit = 16.sp,
        containerSize: Dp = digitSize.value.dp * 2,
        digitCount: Int = 4,
        type: Int = PIN_VIEW_TYPE_UNDERLINE,
    ) {
        BasicTextField(value = pinText,
            onValueChange = onPinTextChange,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            decorationBox = {
                Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    repeat(digitCount) { index ->
                        DigitView(index, pinText, digitColor, digitSize, containerSize, type = type)
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                }
            })
    }


    @Composable
    private fun DigitView(
        index: Int,
        pinText: String,
        digitColor: androidx.compose.ui.graphics.Color,
        digitSize: TextUnit,
        containerSize: Dp,
        type: Int = Companion.PIN_VIEW_TYPE_UNDERLINE,
    ) {
        val isFilled = pinText.length-1 >= index
        val modifier = if (type == Companion.PIN_VIEW_TYPE_BORDER) {
            Modifier
                .size(containerSize)
                .border(
                    width = 1.dp,
                    color = if (isFilled) {
                        colorResource(id = R.color.active)
                    } else {
                        digitColor
                    },
                    shape = MaterialTheme.shapes.medium
                )

        } else Modifier.size(containerSize)
       
        Box(contentAlignment = Alignment.Center, modifier = modifier)
             {
            Text(
                text = if (index >= pinText.length) "" else pinText[index].toString(),
                color = digitColor,
                modifier = Modifier.align(alignment = Alignment.Center),
                style = TextStyle(color = colorResource(id = R.color.signtext), fontFamily = latofamily , fontWeight = FontWeight(400)),
                fontSize = digitSize,
                textAlign = TextAlign.Center)
        }
    }

    companion object {
        const val PIN_VIEW_TYPE_UNDERLINE = 0
        const val PIN_VIEW_TYPE_BORDER = 1
    }

}


