package com.example.data.model

object RepairDatabase {

    val appliances: List<Appliance> = listOf(
        // 1. FAN
        Appliance(
            id = "fan",
            name = "Fan",
            icon = "🌀",
            hindiName = "पंखा (सीलिंग / टेबल)",
            safetyNote = "Koi bhi repair karne se pehle switch band karein aur plug nikaalein. Seedhe taar ko haath na lagayein.",
            problems = listOf(
                Problem(
                    id = "fan1",
                    title = "Fan bilkul nahi chalta",
                    keywords = "band chalta nahi start nahi dead ruk gaya off",
                    symptomDescription = "Switch on karne par bhi pankha bilkul nahi ghoomta aur na koi awaaz aati hai.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Regulator kharab",
                            minCost = 100,
                            maxCost = 350,
                            techRequired = false,
                            tip = "Regulator ko bypass karke seedha chalaakar dekhein ya doosra regulator laga kar test karein.",
                            partsEstimate = "Electronic step regulator: ₹80 - ₹250"
                        ),
                        Cause(
                            name = "Capacitor kharab",
                            minCost = 150,
                            maxCost = 350,
                            techRequired = true,
                            tip = "Fan hum-hum karta hai par ghoomta nahi, to capacitor sabse zyada sambhavit hai.",
                            partsEstimate = "2.5 mfd / 3.15 mfd condenser: ₹40 - ₹80 + mistri charge"
                        ),
                        Cause(
                            name = "Wiring/connection dheela",
                            minCost = 100,
                            maxCost = 250,
                            techRequired = true,
                            tip = "Switch board aur fan ke terminal check karwayein. Loose connection se sparking ho sakti hai.",
                            partsEstimate = "Terminal block ya fresh wire"
                        ),
                        Cause(
                            name = "Motor winding jal gayi",
                            minCost = 450,
                            maxCost = 1100,
                            techRequired = true,
                            tip = "Jalne ki gandh aaye to turant band karein. Rewinding ya naya fan lene ka daam compare karein.",
                            partsEstimate = "Copper winding rewinding: ₹400 - ₹900"
                        )
                    )
                ),
                Problem(
                    id = "fan2",
                    title = "Fan dheere ghoomta hai",
                    keywords = "dheere slow speed kam hawa kam dheema",
                    symptomDescription = "Full speed par bhi pankha bahut slow chalta hai aur poori hawa nahi milti.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Capacitor kamzor (Weak Capacitor)",
                            minCost = 150,
                            maxCost = 350,
                            techRequired = true,
                            tip = "Dande ya haath se ghumane par fan thoda tez ho jaye to capacitor ki samasya pakki hai.",
                            partsEstimate = "Naya 2.5 mfd capacitor lagayein"
                        ),
                        Cause(
                            name = "Bearing sookhi ya ghis gayi",
                            minCost = 200,
                            maxCost = 500,
                            techRequired = true,
                            tip = "Grease sookhne par motor par load padta hai. Oiling/greasing ya bearing replacement se theek hota hai.",
                            partsEstimate = "6201/6202 ball bearings"
                        ),
                        Cause(
                            name = "Regulator kharab",
                            minCost = 100,
                            maxCost = 350,
                            techRequired = false,
                            tip = "Alag speed steps par check karein. Agar 1 aur 5 par ek jaisi speed ho to regulator badlein.",
                            partsEstimate = "Naya modular regulator"
                        )
                    )
                ),
                Problem(
                    id = "fan3",
                    title = "Awaaz ya hilna (Noise / Wobble)",
                    keywords = "awaaz shor khadkhad vibration hilta noise cheekh ghurr",
                    symptomDescription = "Pankha chalte waqt ghurr-ghurr, cheekhne ki ya khad-khad awaaz karta hai ya hilta hai.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Blade par dhool ya blade mudi hui",
                            minCost = 0,
                            maxCost = 250,
                            techRequired = false,
                            tip = "Blades saaf karein aur screws kasein. Agar ek blade jhuka ho to haath se halke se barabar karein.",
                            partsEstimate = "Khaali kapda ya cleaning brush"
                        ),
                        Cause(
                            name = "Dhila screw ya canopy loose",
                            minCost = 0,
                            maxCost = 100,
                            techRequired = false,
                            tip = "Stool ya seedhi par chadhne se pehle fan band aur switch off karein. Screwdriver se kasein.",
                            partsEstimate = "Screw tightening (muft DIY)"
                        ),
                        Cause(
                            name = "Bearing kharab",
                            minCost = 200,
                            maxCost = 500,
                            techRequired = true,
                            tip = "Ghurr-ghurr lagataar awaaz bearing kharab hone ki nishani hai. Jyada din chalane par motor jaam ho sakti hai.",
                            partsEstimate = "Bearing set replacement"
                        )
                    )
                ),
                Problem(
                    id = "fan4",
                    title = "Garam hona ya jalne ki gandh",
                    keywords = "garam gandh dhuan jal burning smell hot heating coil",
                    symptomDescription = "Pankhe se jalne ki gandh, dhuan ya motor body behad garam ho jana.",
                    urgent = true,
                    causes = listOf(
                        Cause(
                            name = "Winding short ya overload",
                            minCost = 450,
                            maxCost = 1100,
                            techRequired = true,
                            tip = "Turant switch band karein! Dobara na chalayein warna aag lagne ka khatra rehta hai.",
                            partsEstimate = "Complete rewinding ya naya stator"
                        ),
                        Cause(
                            name = "Bearing jam",
                            minCost = 250,
                            maxCost = 600,
                            techRequired = true,
                            tip = "Jam bearing motor ko ghuma nahi paati aur electricity heat ban kar motor ko garam kar deti hai.",
                            partsEstimate = "Bearing + shaft check"
                        )
                    )
                )
            )
        ),

        // 2. COOLER
        Appliance(
            id = "cooler",
            name = "Cooler",
            icon = "❄️",
            hindiName = "एयर कूलर (डेजर्ट / रूम)",
            safetyNote = "Pani aur bijli saath hain. Mains band karke plug nikaalein. Geele haath se kabhi na chhuyein. Body mein current mehsoos ho to cooler na chhuyein.",
            problems = listOf(
                Problem(
                    id = "c1",
                    title = "Thandi hawa nahi aa rahi",
                    keywords = "thanda nahi garam hawa thandak cooling pani pump dry",
                    symptomDescription = "Fan chalta hai lekin room thanda nahi ho raha aur garam hawa phenk raha hai.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Pani pump kharab ya pipe band",
                            minCost = 250,
                            maxCost = 650,
                            techRequired = false,
                            tip = "Pump ki awaaz suniye. Pipe ke chhed (distributor holes) saaf karein. Naya submersible pump lagana aasaan hai.",
                            partsEstimate = "Cooler submersible pump: ₹150 - ₹350"
                        ),
                        Cause(
                            name = "Honeycomb pad purane ya jam",
                            minCost = 250,
                            maxCost = 900,
                            techRequired = false,
                            tip = "Pad par safed jama hua namak/kachra ho to badal dein. Khas ya honeycomb fresh ho to hi thandak aati hai.",
                            partsEstimate = "Honeycomb / Wood wool set: ₹200 - ₹700"
                        ),
                        Cause(
                            name = "Tanki mein pani kam ya distribution off",
                            minCost = 0,
                            maxCost = 0,
                            techRequired = false,
                            tip = "Float valve aur tank level check karein. Kamre mein cross ventilation (khidki khuli) zaroor rakhein.",
                            partsEstimate = "Muft (Self Check)"
                        )
                    )
                ),
                Problem(
                    id = "c2",
                    title = "Motor hum karta hai par ghoomta nahi",
                    keywords = "motor hum ghoomta nahi atka jam phansa fan blade",
                    symptomDescription = "Switch dabane par motor se gunjna sunai deta hai lekin fan blades nahi ghoomte.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Capacitor kharab",
                            minCost = 150,
                            maxCost = 350,
                            techRequired = true,
                            tip = "Pehle plug nikaalein! Fir haath se blade ghuma kar dekhein. Agar aasani se ghoome to capacitor badalna hoga.",
                            partsEstimate = "4 to 6 mfd capacitor"
                        ),
                        Cause(
                            name = "Motor bearing / bush jam",
                            minCost = 300,
                            maxCost = 800,
                            techRequired = true,
                            tip = "Blade haath se ghumane par sakht lage to bush ya bearing jam ho chuki hai. Mistri se theek karwayein.",
                            partsEstimate = "Bush kit ya bearing change"
                        ),
                        Cause(
                            name = "Motor jal gayi (Burned Motor)",
                            minCost = 800,
                            maxCost = 2200,
                            techRequired = true,
                            tip = "Agar gandh aaye aur motor garam ho to rewinding ya naye motor ka daam compare karein.",
                            partsEstimate = "Nayi cooler motor ₹1200 - ₹2000"
                        )
                    )
                ),
                Problem(
                    id = "c3",
                    title = "Body mein current / jhatka",
                    keywords = "current jhatka shock bijli earthing shocker body leek",
                    symptomDescription = "Cooler ki metal body ya paani ko chhoone par current ya tingling jhatka lagta hai.",
                    urgent = true,
                    causes = listOf(
                        Cause(
                            name = "Earthing nahi hai ya wiring mein leakage",
                            minCost = 200,
                            maxCost = 800,
                            techRequired = true,
                            tip = "Cooler ko TURANT band karein! 3-pin plug mein earth wire zaroori hai. Electrician se board earthing check karwayein.",
                            partsEstimate = "Earthing wire & plug replacement"
                        ),
                        Cause(
                            name = "Pump ya motor ka insulation kharab",
                            minCost = 300,
                            maxCost = 1500,
                            techRequired = true,
                            tip = "Pani me doobe pump ki taar kati ho sakti hai. Kisi bhi hisse ko geele haath se na chhuyein.",
                            partsEstimate = "Waterproof pump replacement"
                        )
                    )
                ),
                Problem(
                    id = "c4",
                    title = "Hawa kam ya tez awaaz",
                    keywords = "hawa kam awaaz shor blade belt vibration speed",
                    symptomDescription = "Cooler bahut tez awaaz karta hai ya motor chalte huye bhi hawa ka pressure kam hai.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Pad ya mesh filter jaam",
                            minCost = 250,
                            maxCost = 900,
                            techRequired = false,
                            tip = "Peeche ki jali aur pads par dhool jamne se hawa aana band ho jaati hai. Paani ke pressure se dho lijiye.",
                            partsEstimate = "Pads cleaning ya replacement"
                        ),
                        Cause(
                            name = "Blade dhila ya tedha",
                            minCost = 100,
                            maxCost = 400,
                            techRequired = false,
                            tip = "Motor shaft ka nut tight karein aur check karein ki blade body se takra to nahi raha.",
                            partsEstimate = "Shaft lock nut / replacement blade"
                        ),
                        Cause(
                            name = "Motor kamzor ya winding weak",
                            minCost = 300,
                            maxCost = 2200,
                            techRequired = true,
                            tip = "Technician se motor ke RPM aur voltage drop test karwayein.",
                            partsEstimate = "Motor servicing"
                        )
                    )
                )
            )
        ),

        // 3. MOBILE
        Appliance(
            id = "mobile",
            name = "Mobile",
            icon = "📱",
            hindiName = "मोबाइल फोन (स्मार्टफोन)",
            safetyNote = "Phool hui battery, garam phone ya dhuan ho to use turant band karein aur chaarge se hatayein. Khud battery na kholein.",
            problems = listOf(
                Problem(
                    id = "m1",
                    title = "Charge nahi hota",
                    keywords = "charge nahi charging port cable adapter charging slow battery",
                    symptomDescription = "Charger lagane par koi animation ya charging indicator nahi aata ya hilane par chalta hai.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Charger ya cable kharab",
                            minCost = 150,
                            maxCost = 800,
                            techRequired = false,
                            tip = "Doosra original cable/adapter try karein. Ghar ke kisi aur phone ke charger se test karein.",
                            partsEstimate = "Type-C / Lightning cable"
                        ),
                        Cause(
                            name = "Charging Port mein dhool / lint",
                            minCost = 0,
                            maxCost = 150,
                            techRequired = false,
                            tip = "Phone switch off karein. Lakdi ki patli teeli (toothpick) se halke se port ke kone saaf karein. Dhaatu/pin na dalein.",
                            partsEstimate = "Muft cleaning"
                        ),
                        Cause(
                            name = "Charging sub-board / port kharab",
                            minCost = 300,
                            maxCost = 1000,
                            techRequired = true,
                            tip = "Cable hilane par hi charge ho to port pin ghis chuki hai. Charging CC board badalna padega.",
                            partsEstimate = "CC charging board: ₹250 - ₹600"
                        ),
                        Cause(
                            name = "Battery khatam (Dead Battery)",
                            minCost = 500,
                            maxCost = 2200,
                            techRequired = true,
                            tip = "2-3 saal purane phone mein battery deep discharge ya dead ho sakti hai.",
                            partsEstimate = "Replacement original/OEM battery"
                        )
                    )
                ),
                Problem(
                    id = "m2",
                    title = "Battery jaldi khatam hoti hai",
                    keywords = "battery jaldi drain backup kam discharge percent drop",
                    symptomDescription = "Subah 100% karne ke baad 3-4 ghante mein phone ki battery 20% par aa jati hai.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Background apps ya software bug",
                            minCost = 0,
                            maxCost = 0,
                            techRequired = false,
                            tip = "Settings > Battery usage dekhein. Jo anjaan app battery kha rahi ho use uninstall karein aur screen brightness kam rakhein.",
                            partsEstimate = "Muft DIY fix"
                        ),
                        Cause(
                            name = "Battery ki life poori (Degraded Health)",
                            minCost = 500,
                            maxCost = 2200,
                            techRequired = true,
                            tip = "Agar phone 2 saal se purana hai aur battery health 80% se kam hai, to nayi battery dalwayein.",
                            partsEstimate = "Battery replacement + labour"
                        )
                    )
                ),
                Problem(
                    id = "m3",
                    title = "Screen toota ya touch nahi chalta",
                    keywords = "screen toota touch display crack kaam nahi glass display",
                    symptomDescription = "Girne se screen par crack aa gaya hai ya screen ka aadha hissa touch respond nahi kar raha.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Sirf upar ka glass toota, display sahi hai",
                            minCost = 600,
                            maxCost = 2500,
                            techRequired = true,
                            tip = "Pehle tempered glass hatakar dekhein. Agar screen andar se saaf dikh rahi hai to sirf OCA glass change ho sakta hai.",
                            partsEstimate = "OCA glass lamination"
                        ),
                        Cause(
                            name = "Poora display / folder kharab",
                            minCost = 1200,
                            maxCost = 8000,
                            techRequired = true,
                            tip = "Kalee lines ya rang bikhre dikhein to poora combo/folder badlega. Brand service centre aur local rate compare karein.",
                            partsEstimate = "LCD combo ₹1200-₹2500, AMOLED combo ₹3500-₹8000"
                        )
                    )
                ),
                Problem(
                    id = "m4",
                    title = "Phone hang ya bahut garam",
                    keywords = "hang garam slow atakta heat lag freeze restart",
                    symptomDescription = "Apps kholne par phone ruk ruk kar chalta hai aur camera/call karte waqt peeche se garam hota hai.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Internal storage bhara hua",
                            minCost = 0,
                            maxCost = 0,
                            techRequired = false,
                            tip = "Kam se kam 15% phone memory khaali rakhein. WhatsApp video aur unused apps delete karein.",
                            partsEstimate = "Muft"
                        ),
                        Cause(
                            name = "Software corrupt ya kharab update",
                            minCost = 0,
                            maxCost = 400,
                            techRequired = false,
                            tip = "Photos/contacts ka backup lein aur ek baar Phone ko Factory Reset kar lein. 90% hang issues theek hote hain.",
                            partsEstimate = "Software flashing if needed"
                        ),
                        Cause(
                            name = "Motherboard IC ya battery swelling",
                            minCost = 500,
                            maxCost = 4000,
                            techRequired = true,
                            tip = "Reset ke baad bhi phone khade-khade garam ho to power IC ya battery issue ho sakta hai.",
                            partsEstimate = "Chip level repair"
                        )
                    )
                ),
                Problem(
                    id = "m5",
                    title = "Paani gir gaya (Water Damage)",
                    keywords = "paani pani gir bheeg water liquid geela baarish",
                    symptomDescription = "Phone paani, chai ya toilet me gir gaya hai.",
                    urgent = true,
                    causes = listOf(
                        Cause(
                            name = "Liquid damage & short circuit",
                            minCost = 500,
                            maxCost = 3000,
                            techRequired = true,
                            tip = "GALTI NA KAREIN: Phone ko switch on ya CHARGE BILKUL NA KAREIN! Chawal (rice) mein na rakhein. Phone band karke seedha technician ke paas ultrasonic cleaning ke liye le jayein.",
                            partsEstimate = "Ultrasonic bath & dry service: ₹300 - ₹800"
                        )
                    )
                )
            )
        ),

        // 4. FRIDGE
        Appliance(
            id = "fridge",
            name = "Fridge",
            icon = "🧊",
            hindiName = "फ्रिज (रेफ्रिजरेटर)",
            safetyNote = "Fridge kholkar pichhe ka hissa ya gas pipe na chhuyein. Repair ke pehle plug nikaalein.",
            problems = listOf(
                Problem(
                    id = "f1",
                    title = "Thanda nahi karta (No Cooling)",
                    keywords = "thanda nahi cooling gas compressor thermostat heat warm",
                    symptomDescription = "Fridge me light jal rahi hai lekin freezer ya niche ke khane me thandak nahi ho rahi.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Thermostat setting galat ya kharab",
                            minCost = 0,
                            maxCost = 1000,
                            techRequired = false,
                            tip = "Pehle cooling dial ko 3 ya 4 par rakhein. Agar fir bhi compressor start na ho to thermostat switch check karwayein.",
                            partsEstimate = "Thermostat replacement: ₹300 - ₹700"
                        ),
                        Cause(
                            name = "Door gasket rubber dhila / leak",
                            minCost = 400,
                            maxCost = 1200,
                            techRequired = false,
                            tip = "Darwaze ke rubber ke beech kagaz ka tukda phasa kar dekhein. Agar aasani se nikal aaye to bahar ki garam hawa andar ja rahi hai.",
                            partsEstimate = "Magnetic door gasket set"
                        ),
                        Cause(
                            name = "Cooling Gas leak (Refrigerant)",
                            minCost = 1500,
                            maxCost = 3500,
                            techRequired = true,
                            tip = "Compressor chal raha ho par cooling bilkul zero ho to gas leak ho sakti hai. Pehle leak repair karwayein fir gas refilling.",
                            partsEstimate = "R134a / R600a gas charging + pin valve"
                        ),
                        Cause(
                            name = "Compressor kharab ya relay dead",
                            minCost = 3000,
                            maxCost = 8000,
                            techRequired = true,
                            tip = "Pichhe se 'tick... tick' awaaz aaye to pehle ₹200 ki relay/overload protector badal kar dekhein. Compressor badalne se pehle naye fridge ki keemat compare karein.",
                            partsEstimate = "PTC Relay/OLP: ₹200 - ₹500, Naya compressor: ₹3500 - ₹7000"
                        )
                    )
                ),
                Problem(
                    id = "f2",
                    title = "Paani leak ya barf jam gayi",
                    keywords = "paani leak barf jam ice defrost drain freezer overfreeze",
                    symptomDescription = "Freezer ke neeche paani tapakta hai ya freezer me bahut moti barf ki chadar jam jati hai.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Drain pipe band (Choked Drain)",
                            minCost = 0,
                            maxCost = 300,
                            techRequired = false,
                            tip = "Freezer ke niche ka chhota hole kachre se band ho jata hai. Gungune paani aur flexible taar se halke se saaf karein.",
                            partsEstimate = "Muft DIY fix"
                        ),
                        Cause(
                            name = "Defrost heater ya bimetal sensor kharab",
                            minCost = 600,
                            maxCost = 2000,
                            techRequired = true,
                            tip = "Frost-free fridge me agar freezer me moti barf jam jaye aur niche hawa na pahuche to defrost system kharab hai.",
                            partsEstimate = "Bimetal thermostat / Defrost timer"
                        )
                    )
                ),
                Problem(
                    id = "f3",
                    title = "Bahut awaaz karta hai (Vibration / Noise)",
                    keywords = "awaaz shor noise hum rattle compressor thumping",
                    symptomDescription = "Fridge chalte waqt khad-khad ya jhanjhanahat ki tez awaaz aati hai.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Fridge ka level tedha ya deewar se sata hua",
                            minCost = 0,
                            maxCost = 0,
                            techRequired = false,
                            tip = "Neeche ke adjustable pairon ko ghumakar barabar karein. Fridge ko pichhe ki deewar se kam se kam 4 inch door rakhein.",
                            partsEstimate = "Muft adjustment"
                        ),
                        Cause(
                            name = "Evaporator fan ya compressor rubber mount ghis gaya",
                            minCost = 400,
                            maxCost = 6000,
                            techRequired = true,
                            tip = "Agar fan blade barf se takra raha ho ya compressor ke rubber pad sookh gaye hon to technician ko dikhayein.",
                            partsEstimate = "Rubber grommets ya fan motor"
                        )
                    )
                )
            )
        ),

        // 5. WASHING MACHINE
        Appliance(
            id = "washing_machine",
            name = "Washing Machine",
            icon = "🧺",
            hindiName = "वॉशिंग मशीन (ऑटो / सेमी)",
            safetyNote = "Machine kholne se pehle power cord aur water inlet tap band karein. Spin drum ghoomte waqt andar haath na daalein.",
            problems = listOf(
                Problem(
                    id = "wm1",
                    title = "Spin nahi hota / kapde geele reh jate hain",
                    keywords = "spin drain kapde geele sukhana suhana dryer ruk gaya",
                    symptomDescription = "Dhone ke baad machine spin cycle me nahi jaati ya kapde behad geele nikalte hain.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Drain filter / coin trap jaam",
                            minCost = 0,
                            maxCost = 250,
                            techRequired = false,
                            tip = "Front ya bottom corner me drain filter khol kar dekhein. Sikka, pin ya dhaga phasa ho sakta hai.",
                            partsEstimate = "Filter cleaning"
                        ),
                        Cause(
                            name = "Door switch / lid switch kharab",
                            minCost = 350,
                            maxCost = 900,
                            techRequired = true,
                            tip = "Safety sensor machine ko spin nahi hone deta agar use lage ki dhakkan khula hai.",
                            partsEstimate = "Lid sensor switch"
                        ),
                        Cause(
                            name = "Motor belt dhili ya toot gayi",
                            minCost = 300,
                            maxCost = 850,
                            techRequired = true,
                            tip = "Motor ghoom rahi hai par drum nahi ghoom raha to rubber drive belt kharab ho chuki hai.",
                            partsEstimate = "Rubber V-belt ₹150 - ₹350"
                        )
                    )
                ),
                Problem(
                    id = "wm2",
                    title = "Paani andar nahi aata ya leak hota hai",
                    keywords = "paani water inlet valve pipe leak girna tap tapak",
                    symptomDescription = "Start karne par nal se paani machine me nahi bharta ya neeche se paani behta hai.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Inlet valve mesh filter par kachra",
                            minCost = 0,
                            maxCost = 200,
                            techRequired = false,
                            tip = "Inlet pipe khol kar machine ke pichhe lagi jali ko purane toothbrush se saaf karein.",
                            partsEstimate = "Muft cleaning"
                        ),
                        Cause(
                            name = "Water inlet solenoid valve kharab",
                            minCost = 450,
                            maxCost = 1200,
                            techRequired = true,
                            tip = "Current aane par bhi magnet valve nahi khul raha to valve badalna hoga.",
                            partsEstimate = "Dual/Single solenoid valve"
                        ),
                        Cause(
                            name = "Drain bellows hose pipe phata hua",
                            minCost = 250,
                            maxCost = 700,
                            techRequired = true,
                            tip = "Tub ke niche ka bellows pipe chuhe ne kaat diya ho to paani niche girta hai.",
                            partsEstimate = "Drain hose replacement"
                        )
                    )
                ),
                Problem(
                    id = "wm3",
                    title = "Bahut zyada awaaz aur uchhalna (Heavy Vibration)",
                    keywords = "awaaz hilna uchhalna vibration shor drum takrana thumping",
                    symptomDescription = "Spin karte waqt washing machine poori hilne lagti hai aur farsh par aage khisak jaati hai.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Kapdon ka unbalance load",
                            minCost = 0,
                            maxCost = 0,
                            techRequired = false,
                            tip = "Ek taraf bhari kambal ya jeans ekattha ho gaya ho. Kapde faila kar barabar rakhein.",
                            partsEstimate = "Muft adjustment"
                        ),
                        Cause(
                            name = "Shock absorber ya suspension rod kharab",
                            minCost = 600,
                            maxCost = 2200,
                            techRequired = true,
                            tip = "Top-load machine ki 4 suspension rods me se 1 bhi kamzor ho to drum deewaron se takrata hai.",
                            partsEstimate = "Suspension rod set (4 piece)"
                        )
                    )
                )
            )
        ),

        // 6. MICROWAVE & INDUCTION
        Appliance(
            id = "microwave",
            name = "Microwave & Induction",
            icon = "⚡",
            hindiName = "माइक्रोवेव / इंडक्शन चूल्हा",
            safetyNote = "Microwave ke high voltage capacitor mein band hone ke baad bhi 2000+ volts ka current rehta hai! Khud kabhi cabinet na kholein.",
            problems = listOf(
                Problem(
                    id = "mw1",
                    title = "Chalta hai par khana garam nahi hota",
                    keywords = "garam nahi magnetron heat heatless light microwave fuse",
                    symptomDescription = "Microwave ka timer chalta hai, turntable ghoomta hai lekin khana bilkul thanda rehta hai.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "High voltage fuse ud gaya",
                            minCost = 350,
                            maxCost = 800,
                            techRequired = true,
                            tip = "Voltage spike ki wajah se HV diode ya fuse ud jata hai. Mistri se change karwayein.",
                            partsEstimate = "5kV HV Fuse"
                        ),
                        Cause(
                            name = "Magnetron tube kharab",
                            minCost = 1200,
                            maxCost = 2800,
                            techRequired = true,
                            tip = "Khana garam karne wali mukhya tube dead ho chuki hai. Brand model ke anusar replace hoti hai.",
                            partsEstimate = "OEM Magnetron"
                        )
                    )
                ),
                Problem(
                    id = "mw2",
                    title = "Induction par bartan detect nahi hota (E0 / E1 Error)",
                    keywords = "induction error e0 e1 bartan vessel plate detect chulha",
                    symptomDescription = "Bartan rakhne par bhi 'beep beep' karta hai aur error code dikhata hai.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Bartan ferromagnetic (induction friendly) nahi hai",
                            minCost = 0,
                            maxCost = 0,
                            techRequired = false,
                            tip = "Chumbak (magnet) se bartan ke tale ko check karein. Agar magnet chipke to hi induction par chalega.",
                            partsEstimate = "Muft test"
                        ),
                        Cause(
                            name = "Main IGBT transistor ya thermal sensor kharab",
                            minCost = 400,
                            maxCost = 1100,
                            techRequired = true,
                            tip = "Induction board ka IGBT chip ya bridge rectifier ud gaya hai. Electronic shop par theek hota hai.",
                            partsEstimate = "IGBT 25N120 + fuse: ₹200 - ₹500"
                        )
                    )
                ),
                Problem(
                    id = "mw3",
                    title = "Chingaari nikalna (Sparking inside Microwave)",
                    keywords = "chingaari spark aag aag ke gole microwave mica sheet",
                    symptomDescription = "Microwave on karte hi andar tez patakha phutne aur chingaari ki awaaz aati hai.",
                    urgent = true,
                    causes = listOf(
                        Cause(
                            name = "Mica waveguide cover par tel ya jal gaya",
                            minCost = 150,
                            maxCost = 450,
                            techRequired = false,
                            tip = "Deewar par lagi silver cardboard jaisi mica sheet saaf karein ya nayi sheet kaat kar laga dein.",
                            partsEstimate = "Mica sheet: ₹50 - ₹120"
                        ),
                        Cause(
                            name = "Dhaatu (metal / aluminium foil) galti se andar reh gaya",
                            minCost = 0,
                            maxCost = 0,
                            techRequired = false,
                            tip = "Turant off karein aur metal bartan bahar nikaalein. Sirf microwave-safe glass ya ceramic use karein.",
                            partsEstimate = "Muft DIY precaution"
                        )
                    )
                )
            )
        ),

        // 7. WATER PURIFIER / RO
        Appliance(
            id = "ro_purifier",
            name = "Water Purifier (RO)",
            icon = "💧",
            hindiName = "पानी का आरओ (RO / UV Purifier)",
            safetyNote = "Filter change karne se pehle adapter switch off karein aur input water valve band karein.",
            problems = listOf(
                Problem(
                    id = "ro1",
                    title = "Paani bilkul nahi nikal raha ya boond-boond gir raha",
                    keywords = "ro paani nahi flow slow boond boond filter band choke",
                    symptomDescription = "RO on hai lekin tanki nahi bhar rahi aur nal se boond-boond paani tapak raha hai.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Pre-filter spun candle mitti se jaam",
                            minCost = 150,
                            maxCost = 350,
                            techRequired = false,
                            tip = "Bahar laga safed bowl khol kar PP spun filter badlein. Agar brown/black ho chuka hai to paani ruk jata hai.",
                            partsEstimate = "PP Spun Candle: ₹50 - ₹120"
                        ),
                        Cause(
                            name = "RO Membrane choke ho gayi",
                            minCost = 900,
                            maxCost = 2200,
                            techRequired = true,
                            tip = "Agar waste water nikal raha hai par pure water nahi, to membrane choke ho chuki hai.",
                            partsEstimate = "75/80 GPD RO Membrane"
                        ),
                        Cause(
                            name = "Booster pump ka pressure kam ho gaya",
                            minCost = 1200,
                            maxCost = 2500,
                            techRequired = true,
                            tip = "Membrane ke liye 80-100 PSI pressure chahiye. Kamzor pump membrane se paani pass nahi kara pata.",
                            partsEstimate = "RO Booster Pump: ₹900 - ₹1800"
                        )
                    )
                ),
                Problem(
                    id = "ro2",
                    title = "Paani ka swaad (taste) kharab ya smell",
                    keywords = "swaad taste badbo smell kadwa taste purifier filter",
                    symptomDescription = "Paani me kadwahat, mitti jaisi badboo ya metallic swaad aa raha hai.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Activated Carbon Filter purana ho gaya",
                            minCost = 300,
                            maxCost = 700,
                            techRequired = true,
                            tip = "Carbon filter chlorine aur smell sokhta hai. Har 8-12 mahine mein badalna zaroori hai.",
                            partsEstimate = "Pre/Post Carbon filter cartridge"
                        ),
                        Cause(
                            name = "Storage tank mein algae ya kachra",
                            minCost = 0,
                            maxCost = 300,
                            techRequired = false,
                            tip = "Tank khol kar saaf paani aur thode vinegar/warm water se dho lijiye.",
                            partsEstimate = "Muft cleaning"
                        )
                    )
                ),
                Problem(
                    id = "ro3",
                    title = "Lagataar waste water beh raha hai (Wasting Water non-stop)",
                    keywords = "waste paani pipe lagataar drainage solenoid sv valve",
                    symptomDescription = "Tank pura bhar jaane ke baad bhi waste pipe se paani behna band nahi hota.",
                    urgent = false,
                    causes = listOf(
                        Cause(
                            name = "Solenoid Valve (SV) kharab ya khula atka hua",
                            minCost = 350,
                            maxCost = 750,
                            techRequired = true,
                            tip = "SV switch off hone par bhi paani rok nahi pata. Naya 24V SV lagayein.",
                            partsEstimate = "Automatic Solenoid Valve: ₹200 - ₹450"
                        ),
                        Cause(
                            name = "Auto cut-off float switch kharab",
                            minCost = 200,
                            maxCost = 500,
                            techRequired = true,
                            tip = "Tank bharne par float switch motor aur SV ko cut-off signal nahi de raha.",
                            partsEstimate = "Float micro-switch"
                        )
                    )
                )
            )
        )
    )

    fun searchProblems(query: String): List<SearchResult> {
        val trimmed = query.trim().lowercase()
        if (trimmed.isEmpty()) return emptyList()

        val tokens = trimmed.split(Regex("[^a-z0-9\u0900-\u097f]+")).filter { it.isNotBlank() }
        if (tokens.isEmpty()) return emptyList()

        val results = mutableListOf<SearchResult>()

        for (appliance in appliances) {
            for (problem in appliance.problems) {
                val corpus = "${appliance.name} ${appliance.hindiName} ${problem.title} ${problem.keywords} ${problem.symptomDescription} " +
                        problem.causes.joinToString(" ") { "${it.name} ${it.tip}" }
                val lowerCorpus = corpus.lowercase()

                var score = 0
                for (token in tokens) {
                    if (lowerCorpus.contains(token)) {
                        score += 3
                    }
                    if (problem.title.lowercase().contains(token)) {
                        score += 5
                    }
                    if (problem.keywords.lowercase().contains(token)) {
                        score += 4
                    }
                }

                if (score > 0) {
                    results.add(SearchResult(appliance, problem, score))
                }
            }
        }

        return results.sortedByDescending { it.score }.take(10)
    }

    fun getApplianceById(id: String): Appliance? = appliances.find { it.id == id }

    fun getProblemById(applianceId: String, problemId: String): Pair<Appliance, Problem>? {
        val app = getApplianceById(applianceId) ?: return null
        val prob = app.problems.find { it.id == problemId } ?: return null
        return Pair(app, prob)
    }
}
