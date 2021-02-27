package com.example.androiddevchallenge

object Util {

    private val list: ArrayList<Puppy> = ArrayList()

    private val beagle = Puppy("Clyde", R.drawable.beagle, 0, "Beagle","Male","Canine Estates\nEdinburgh, Scotland")
    private val chihuahua = Puppy("Felix", R.drawable.chihuahua, 1, "Chihuahua","Male","Mexican Shelter\nSonora, Mexico")
    private val dachshund = Puppy("Rudy", R.drawable.dachshund, 2, "Dachshund","Male","Mary's Shelter\nVancouver, Canada")
    private val french_bulldog = Puppy("Stewie", R.drawable.french_bulldog, 3, "French Bulldog","Male","Bullseye\nParis, France")
    private val labrador = Puppy("Scooby", R.drawable.labrador, 4, "Labrador","Male","Friends for Life\nDelhi, India")
    private val papillon = Puppy("Olivia", R.drawable.papillon, 5, "Papillon","Female","Fur and Fluff\nBerlin, Germany")
    private val pomeranian = Puppy("Penny", R.drawable.pomeranian, 6, "Pomeranian","Female","Fur and Fluff\nBerlin, Germany")
    private val poodle = Puppy("Luna", R.drawable.poodle, 7, "Poodle","Female","Canine Estates\nEdinburgh, Scotland")
    private val pug = Puppy("Dexter", R.drawable.pug, 8, "Pug","Male","Friends for Life\nDelhi, India")
    private val yorkshire_terrier = Puppy("Rusty", R.drawable.yorkshire_terrier, 9, "Yorkshire Terrier","Male","Faith nad Ruff's\nNottingham, England")
    private val puppy = Puppy("puppy", R.drawable.puppy, 10, "puppy","Male","Unavailable")

    private val description_male = "is staying at the adoption center waiting for someone to visit us and adopt him. He wants you to be his new master, Will you adopt"
    private val description_female = "is staying at the adoption center waiting for someone to visit us and adopt her. She wants you to be her new master, Will you adopt"

    private val beagleDescription = "${beagle.name} ${description_male} ${beagle.name}?"
    private val chihuahuaDescription = "${chihuahua.name} ${description_male} ${chihuahua.name}?"
    private val dachshundDescription = "${dachshund.name} ${description_male} ${dachshund.name}?"
    private val french_bulldogDescription = "${french_bulldog.name} ${description_male} ${french_bulldog.name}?"
    private val labradorDescription = "${labrador.name} ${description_male} ${labrador.name}?"
    private val papillonDescription = "${papillon.name} ${description_female} ${papillon.name}?"
    private val pomeranianDescription = "${pomeranian.name} ${description_female} ${pomeranian.name}?"
    private val poodleDescription = "${poodle.name} ${description_female} ${poodle.name}?"
    private val pugDescription = "${pug.name} ${description_male} ${pug.name}?"
    private val yorkshire_terrier_Description = "${yorkshire_terrier.name} ${description_male} ${yorkshire_terrier.name}?"
    private val puppyDescription = "${puppy.name} ${description_male} ${puppy.name}?"

    fun generateList(): ArrayList<Puppy> {

        list.add(beagle)
        list.add(chihuahua)
        list.add(dachshund)
        list.add(french_bulldog)
        list.add(labrador)
        list.add(papillon)
        list.add(pomeranian)
        list.add(poodle)
        list.add(pug)
        list.add(yorkshire_terrier)

        return list
    }

    fun getPuppyWithIndex(index: Int?): Puppy{
        return when(index) {
            0 -> beagle
            1 -> chihuahua
            2 -> dachshund
            3 -> french_bulldog
            4 -> labrador
            5 -> papillon
            6 -> pomeranian
            7 -> poodle
            8 -> pug
            9 -> yorkshire_terrier
            else ->  puppy
        }
    }

    fun getPuppyDescriptionWithIndex(index: Int?): String {
        return when(index) {
            0 -> beagleDescription
            1 -> chihuahuaDescription
            2 -> dachshundDescription
            3 -> french_bulldogDescription
            4 -> labradorDescription
            5 -> papillonDescription
            6 -> pomeranianDescription
            7 -> poodleDescription
            8 -> pugDescription
            9 -> yorkshire_terrier_Description
            else ->  puppyDescription
        }
    }

}