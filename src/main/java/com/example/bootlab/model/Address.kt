package com.example.bootlab.model

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

class Address(@field:Min(1) var id: Int, var name: String, var address: String)