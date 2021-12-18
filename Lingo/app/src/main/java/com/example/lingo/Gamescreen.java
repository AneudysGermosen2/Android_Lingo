package com.example.lingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.example.lingo.databinding.ActivityGridBinding;
import com.example.lingo.databinding.ActivityInstructionBinding;
import com.example.lingo.databinding.ActivityMainBinding;

import java.util.Random;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Gamescreen extends AppCompatActivity{
    EditText input;
    String guess;

    //ActivityMainBinding binding;
    ActivityGridBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        guess = "beas";
        super.onCreate(savedInstanceState);
        binding = ActivityGridBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //setContentView(R.layout.activity_grid);
        input = findViewById(R.id.user_input);

        String[] dictionary = {"abed", "abet", "able", "ably", "aced", "aces", "ache", "achy", "acid", "acne", "acre", "acts",
                "adds", "adit", "aeon", "aery", "afar", "afro", "aged", "ages", "ahem", "ahoy", "aide", "aids", "ails", "aims",
                "airs", "airy", "ajar", "akin", "alas", "alms", "alps", "also", "alum", "amen", "amid", "ammo", "amok", "amps",
                "anal", "anew", "ankh", "ante", "anti", "ants", "anus", "aped", "apes", "apex", "apse", "aqua", "arab", "arch",
                "arco", "arcs", "area", "arid", "arks", "arms", "army", "arse", "arts", "asap", "ashy", "asia", "asks", "asps",
                "atom", "atop", "auld", "aunt", "aura", "auto", "avid", "avow", "away", "awed", "awes", "awry", "axed", "axel",
                "axes", "axil", "axis", "axle", "axon", "ayes", "baas", "babe", "baby", "back", "bade", "bags", "bail", "bait",
                "bake", "bald", "bale", "balk", "ball", "balm", "band", "bane", "bang", "bank", "bans", "barb", "bard", "bare",
                "barf", "bark", "barn", "bars", "base", "bash", "bask", "bass", "bast", "bate", "bath", "bats", "baud", "bawd",
                "bawl", "bays", "bead", "beak", "beam", "bean", "bear", "beat", "beau", "beck", "beds", "beef", "been", "beep",
                "beer", "bees", "beet", "begs", "bell", "belt", "bend", "bent", "berg", "berm", "best", "beta", "bets", "bevy",
                "beys", "bias", "bibs", "bide", "bids", "bier", "biff", "bike", "bile", "bilk", "bill", "bind", "bins", "bird",
                "bite", "bits", "blab", "blah", "blat", "bled", "blew", "blip", "blob", "bloc", "blot", "blow", "blue", "blur",
                "boar", "boas", "boat", "bobs", "boca", "bock", "bode", "bods", "body", "boer", "boff", "bogs", "boil", "bola",
                "bold", "bolt", "bomb", "bond", "bone", "bong", "bono", "bony", "boob", "book", "boom", "boon", "boor", "boos",
                "boot", "bops", "bore", "born", "bort", "boss", "both", "bout", "bowl", "bows", "boxy", "boyo", "boys", "bozo",
                "brad", "brae", "brag", "bran", "bras", "brat", "braw", "bray", "bred", "brew", "brie", "brig", "brim", "brit",
                "bros", "brow", "brut", "bubs", "buck", "buds", "buff", "bugs", "bulb", "bulk", "bull", "bump", "bums", "bund",
                "bung", "bunk", "buns", "bunt", "buoy", "burg", "burl", "burn", "burp", "burr", "burs", "bury", "bush", "buss",
                "bust", "busy", "buts", "butt", "buys", "buzz", "byes", "byre", "byte", "cabs", "cads", "cafe", "cage", "cake",
                "calk", "call", "calm", "calx", "came", "camp", "cams", "cane", "cans", "cant", "cape", "caps", "card", "care",
                "carp", "cars", "cart", "casa", "case", "cash", "cask", "cast", "cats", "caul", "cave", "cavy", "caws",
                "cays", "cede", "ceil", "cell", "celt", "cent", "cess", "chad", "cham", "chap", "char", "chat", "chaw", "chef",
                "chew", "chia", "chic", "chid", "chin", "chip", "chit", "chop", "chow", "chub", "chug", "chum", "cite", "city",
                "clad", "clam", "clan", "clap", "claw", "clay", "clef", "clew", "clip", "clod", "clog", "clop", "clot", "cloy",
                "club", "clue", "coal", "coat", "coax", "cobs", "cock", "coco", "coda", "code", "cods", "cogs", "coif", "coil",
                "coin", "coir", "coke", "cola", "cold", "cole", "colt", "coma", "comb", "come", "cone", "conk", "cons", "cook",
                "cool", "coon", "coop", "coos", "coot", "cope", "cops", "copy", "cord", "core", "cork", "corn", "cost", "cots",
                "coup", "cove", "cowl", "cows", "cozy", "crab", "crag", "cram", "crap", "craw", "cree", "crew", "crib", "crop",
                "crow", "crud", "crux", "cuba", "cube", "cubs", "cuds", "cued", "cues", "cuff", "cull", "cult", "cunt", "cups",
                "curb", "curd", "cure", "curl", "curs", "curt", "cusp", "cuss", "cute", "cuts", "cyan", "cyme", "cyst", "czar",
                "dabs", "dace", "dads", "daft", "dago", "dais", "dale", "dame", "damn", "damp", "dams", "dane", "dang", "dank",
                "dare", "dark", "darn", "dart", "dash", "data", "date", "daub", "dave", "dawn", "days", "daze", "dead", "deaf",
                "deal", "dean", "dear", "debt", "deck", "deco", "deed", "deem", "deep", "deer", "deft", "defy", "deli", "dell",
                "demo", "dens", "dent", "deny", "desk", "deus", "deux", "deva", "dews", "dewy", "dial", "dias", "dibs", "dice",
                "dick", "died", "diem", "dies", "diet", "digs", "dike", "dill", "dime", "dims", "dine", "ding", "dins", "dint",
                "dips", "dire", "dirk", "dirt", "disc", "dish", "disk", "diva", "dive", "dock", "docs", "dodo", "doer",
                "does", "doff", "doge", "dogs", "dogy", "dojo", "dole", "doll", "dolt", "dome", "done", "dong", "dons", "doom",
                "door", "dope", "dopy", "dorm", "dory", "dose", "doss", "dost", "dote", "doth", "dots", "doty", "dour", "dove",
                "down", "dows", "doxy", "doze", "dozy", "drab", "drag", "dram", "drat", "draw", "dray", "dreg", "drek", "drew",
                "drib", "drip", "drop", "drub", "drug", "drum", "drys", "duad", "dual", "dubs", "duce", "duck", "duct", "dude",
                "duds", "duel", "dues", "duet", "duff", "dugs", "duke", "dull", "duly", "dumb", "dump", "dune", "dung", "dunk",
                "duns", "duos", "dupe", "durn", "dusk", "dust", "duty", "dyad", "dyed", "dyer", "dyes", "dyke", "dyne", "each",
                "earl", "earn", "ears", "ease", "east", "easy", "eats", "eave", "ebbs", "ebon", "echo", "eden", "edge",
                "edgy", "edit", "eels", "eely", "eery", "eggs", "egis", "egos", "elks", "ells", "elms", "elmy", "else", "emir",
                "emit", "emmy", "emus", "ends", "enow", "envy", "eons", "epic", "eras", "ergo", "ergs", "erie", "erin", "erne",
                "erns", "eros", "errs", "erst", "espy", "etch", "etna", "even", "ever", "eves", "evil", "ewer", "ewes", "exam",
                "exes", "exit", "expo", "eyed", "eyer", "eyes", "face", "fact", "fade", "fads", "fags", "fail", "fain", "fair",
                "fait", "fake", "fall", "fame", "fang", "fans", "fare", "farm", "faro", "fart", "fast", "fate", "fats", "faun",
                "faut", "faux", "fawn", "fays", "faze", "fear", "feat", "feds", "feed", "feel", "fees", "feet", "fell", "felt",
                "fend", "fens", "fern", "fess", "feta", "fete", "feud", "fiat", "fief", "fife", "figs", "fiji", "file", "fill",
                "film", "find", "fine", "fink", "finn", "fins", "fire", "firm", "firs", "fish", "fist", "fits", "five", "fizz",
                "flab", "flag", "flak", "flan", "flap", "flat", "flaw", "flax", "flay", "flea", "fled", "flee", "flew", "flex",
                "flip", "flit", "floe", "flog", "flop", "flow", "flux", "foal", "foam", "fobs", "foci", "foes", "fogs", "fogy",
                "foil", "fold", "folk", "fond", "font", "food", "fool", "foot", "fops", "fora", "ford", "fore", "fork", "form",
                "fort", "foul", "four", "fowl", "foxy", "frag", "frat", "fray", "fred", "free", "fret", "frig", "friz", "frog",
                "from", "frow", "fuck", "fuds", "fuel", "fugs", "fuji", "full", "fume", "fumy", "fund", "funk", "furl",
                "furs", "fury", "fuse", "fuss", "fuze", "fuzz", "gabs", "gads", "gaff", "gaga", "gage", "gags", "gain", "gait",
                "gala", "gale", "gall", "gals", "game", "gams", "gamy", "gang", "gaol", "gape", "gaps", "gapy", "garb", "gars",
                "gash", "gasp", "gate", "gats", "gaud", "gave", "gawk", "gays", "gaze", "gear", "geed", "geek", "gees", "geld",
                "gels", "gelt", "gems", "gene", "gens", "gent", "germ", "gets", "geum", "ghat", "ghee", "gibe", "gibs", "gift",
                "gigs", "gila", "gild", "gill", "gilt", "gimp", "gins", "gips", "gird", "girl", "girt", "gist", "give", "glad",
                "glee", "glen", "glib", "glim", "glob", "glom", "glop", "glow", "glue", "glum", "glut", "gnat", "gnaw", "gnus",
                "goad", "goal", "goat", "gobs", "gods", "goer", "goes", "gold", "golf", "gone", "gong", "good", "goof", "gook",
                "goon", "goop", "goos", "gore", "gory", "gosh", "goth", "gout", "gown", "goys", "grab", "grad", "gram", "gras",
                "gray", "grew", "grey", "grid", "grim", "grin", "grip", "grit", "grog", "grot", "grow", "grub", "guam", "guar",
                "guck", "guff", "gulf", "gull", "gulp", "gums", "gung", "gunk", "guns", "guru", "gush", "gust", "guts", "guys",
                "gyms", "gyre", "gyro", "gyve", "hack", "haft", "hags", "hahs", "hail", "hair", "hajj", "hake", "hale", "half",
                "hall", "halo", "halt", "hams", "hand", "hang", "hank", "haps", "hard", "hare", "hark", "harm", "harp", "hart",
                "hash", "hasp", "hast", "hate", "hath", "hats", "haul", "have", "hawk", "haws", "hays", "haze", "hazy", "head",
                "heal", "heap", "hear", "heat", "heck", "heed", "heel", "heft", "heir", "held", "hell", "helm", "help",
                "heme", "hemp", "hems", "hens", "herb", "herd", "here", "hero", "hers", "hest", "hewn", "hews", "hick", "hide",
                "hied", "hies", "high", "hike", "hill", "hilt", "hind", "hint", "hips", "hire", "hiss", "hist", "hits", "hive",
                "hoar", "hoax", "hobo", "hobs", "hock", "hods", "hoed", "hoer", "hoes", "hogs", "hoke", "hold", "hole", "holt",
                "holy", "home", "homo", "homy", "hone", "honk", "hood", "hoof", "hook", "hoop", "hoot", "hope", "hops", "horn",
                "hose", "host", "hots", "hour", "hove", "howl", "hows", "hubs", "huck", "hued", "hues", "huff", "huge", "hugs",
                "hula", "hulk", "hull", "hump", "hums", "hung", "hunk", "huns", "hunt", "hurl", "hurt", "hush", "husk", "huts",
                "hyde", "hymn", "hype", "hypo", "iamb", "ibex", "ibis", "iced", "ices", "icky", "icon", "idea", "idem", "ides",
                "idle", "idly", "idol", "iffy", "ilks", "ills", "imam", "imps", "inca", "inch", "info", "inks", "inky", "inly",
                "inns", "into", "ions", "iota", "iowa", "iran", "iraq", "ired", "ires", "iris", "irks", "iron", "isis", "isle",
                "itch", "item", "ixia", "izar", "jabs", "jack", "jade", "jags", "jail", "jamb", "jams", "jape", "jars", "java",
                "jaws", "jays", "jazz", "jean", "jeep", "jeer", "jeez", "jefe", "jell", "jerk", "jest", "jets", "jeux", "jews",
                "jibe", "jibs", "jiff", "jigs", "jill", "jilt", "jinn", "jinx", "jive", "jobs", "jock", "joey", "jogs", "john",
                "joie", "join", "joke", "jolt", "jots", "jowl", "joys", "judo", "jugs", "juju", "juke", "july", "jump", "june",
                "junk", "jupe", "jure", "jury", "just", "jute", "juts", "kaka", "kale", "kame", "kart", "keel", "keen", "keep",
                "kegs", "kelp", "kent", "kept", "kern", "keys", "khan", "kick", "kids", "kiev", "kike", "kill", "kiln", "kilo",
                "kilt", "kind", "kine", "king", "kink", "kins", "kips", "kirk", "kiss", "kist", "kite", "kith", "kits", "kiwi",
                "knee", "knew", "knit", "knob", "knot", "know", "knox", "kola", "kong", "kook", "kudo", "labs", "lace", "lack",
                "lacy", "lade", "lads", "lady", "lags", "laid", "lain", "lair", "lait", "lake", "laky", "lama", "lamb", "lame",
                "lamp", "lams", "land", "lane", "lank", "laos", "lapp", "laps", "lard", "lark", "lash", "lass", "last", "late",
                "lath", "laud", "lava", "lave", "lawn", "laws", "lays", "laze", "lazy", "lead", "leaf", "leak", "leal", "lean",
                "leap", "lear", "leas", "lech", "leek", "leer", "lees", "left", "legs", "leis", "leks", "lend", "lens",
                "lent", "lese", "less", "lest", "lets", "leva", "levi", "levo", "levy", "lewd", "leys", "liar", "lice", "lick",
                "lido", "lids", "lied", "lief", "lien", "lier", "lies", "lieu", "life", "lift", "like", "lilt", "lily", "lima",
                "limb", "lime", "limn", "limo", "limp", "limy", "line", "ling", "link", "lino", "lins", "lint", "liny", "lion",
                "lips", "lira", "lire", "lisp", "list", "lite", "lith", "lits", "live", "load", "loaf", "loam", "loan", "lobe",
                "lobo", "lobs", "loch", "loci", "lock", "lode", "loft", "loge", "logo", "logs", "logy", "loin", "loll", "lone",
                "long", "look", "loom", "loon", "loop", "loos", "loot", "lope", "lops", "lord", "lore", "lorn", "lory", "lose",
                "loss", "lost", "loth", "lots", "loud", "loup", "lour", "lout", "love", "lows", "luau", "lube", "luck", "luff",
                "luge", "lugs", "lull", "lulu", "lump", "luna", "lune", "lung", "lunk", "luny", "lure", "lurk", "lush", "lust",
                "lute", "luxe", "lyes", "lynx", "lyre", "mace", "mach", "mack", "macs", "made", "mads", "mage", "magi", "mags",
                "maid", "mail", "maim", "main", "make", "mala", "male", "mali", "mall", "malt", "mama", "mane", "mans", "manx",
                "many", "maps", "mare", "mark", "marl", "mars", "mart", "mash", "mask", "mass", "mast", "mate", "math", "mats",
                "maul", "maws", "maxi", "maya", "mayo", "mays", "maze", "mazy", "mead", "meal", "mean", "meas", "meat",
                "mech", "meed", "meek", "meet", "meld", "melt", "memo", "mend", "mens", "menu", "meow", "mere", "mesa", "mesh",
                "mess", "meta", "mete", "mewl", "mews", "mibs", "mica", "mice", "mick", "midi", "mids", "miff", "migs", "mild",
                "mile", "milk", "mill", "mils", "milt", "mime", "mind", "mine", "ming", "mini", "mink", "mint", "minx", "mire",
                "mirk", "mirv", "miry", "mise", "miso", "miss", "mist", "mite", "mitt", "moan", "moas", "moat", "mobs", "mock",
                "mode", "mods", "moil", "mold", "mole", "moll", "molt", "moly", "moms", "monk", "mono", "mons",
                "mony", "mood", "moon", "moor", "moos", "moot", "mope", "mops", "mopy", "more", "morn", "mort", "moss", "most",
                "mote", "moth", "mots", "moue", "move", "mown", "mows", "much", "muck", "muds", "muff", "mugs", "mule", "mull",
                "mump", "mums", "muon", "murk", "muse", "mush", "musk", "muss", "must", "mute", "mutt", "myth", "nabs", "nags",
                "naif", "nail", "name", "nape", "naps", "narc", "nard", "nark", "nary", "nave", "navy", "nays", "nazi",
                "neap", "near", "neat", "nebs", "neck", "need", "neon", "nerd", "ness", "nest", "nets", "news", "newt", "next",
                "nibs", "nice", "nick", "nigh", "nile", "nill", "nils", "nims", "nine", "nips", "nisi", "nits", "nixy", "nobs",
                "nock", "node", "nods", "noel", "noes", "nogs", "noir", "nolo", "nome", "noms", "none", "nook", "noon", "nope",
                "norm", "nose", "nosh", "nosy", "nota", "note", "nots", "noun", "nous", "nova", "nows", "nubs", "nude",
                "nuke", "null", "numb", "nuns", "nuts", "oafs", "oaks", "oars", "oath", "oats", "obey", "odds", "odes", "odin",
                "odor", "ogle", "ogre", "ohio", "ohms", "oils", "oily", "oink", "okay", "olds", "omen", "omit", "once", "ones",
                "only", "onto", "onyx", "oops", "ooze", "oozy", "opal", "open", "opts", "opus", "oral", "orbs", "orca",
                "orcs", "ores", "orgy", "oryx", "oslo", "ouch", "ours", "oust", "outs", "ouzo", "oval", "oven", "over", "ovid",
                "ovum", "owed", "owes", "owls", "owns", "oxen", "oxes", "oyer", "oyes", "oyez", "pace", "pack", "pacs", "pact",
                "pads", "page", "paid", "pail", "pain", "pair", "pale", "pall", "palm", "pals", "pane", "pang", "pans", "pant",
                "papa", "paps", "para", "pard", "pare", "park", "pars", "part", "paso", "pass", "past", "pate", "path", "pats",
                "pave", "pawl", "pawn", "paws", "pays", "peak", "peal", "pean", "pear", "peas", "peat", "peck", "peed",
                "peek", "peel", "peen", "peep", "peer", "pees", "pegs", "peke", "pelf", "pelt", "pend", "pens", "pent", "peon",
                "peps", "pere", "perk", "perm", "pert", "peru", "peso", "pest", "pets", "pews", "phew", "phiz", "pica", "pick",
                "pics", "pied", "pier", "pies", "pigs", "pike", "pile", "pill", "pima", "pimp", "pine", "ping", "pink", "pins",
                "pint", "piny", "pion", "pipe", "pips", "pipy", "pisa", "pish", "piss", "pita", "pith", "pits", "pity", "pius",
                "plan", "plat", "play", "plea", "pled", "plod", "plop", "plot", "plow", "ploy", "plug", "plum", "plus", "pock",
                "poco", "pods", "poem", "poet", "poke", "poky", "pole", "polk", "poll", "polo", "pols", "poly", "pome", "pomp",
                "pond", "pone", "pong", "pons", "pony", "pooh", "pool", "poop", "poor", "pope", "pops", "pore", "pork", "porn",
                "port", "pose", "posh", "post", "posy", "pots", "pouf", "pour", "pout", "pows", "pram", "prat", "pray", "prep",
                "pres", "prey", "prig", "prim", "prix", "proc", "prod", "prof", "prom", "pron", "prop", "pros", "prow", "pubs",
                "puce", "puck", "puds", "puff", "pugs", "puke", "pule", "pull", "pulp", "puma", "pump", "punk", "puns", "punt",
                "puny", "pupa", "pups", "pure", "purl", "purr", "push", "puss", "puts", "putt", "pyre", "qaid", "qoph", "quad",
                "quag", "quay", "ques", "quey", "quid", "quip", "quit",
                "quiz", "race", "rack", "racy", "rads", "raft", "rage", "rags", "raid", "rail", "rain", "raja", "rake", "ramp",
                "rams", "rand", "rang", "rani", "rank", "rant", "rape", "raps", "rare", "rase", "rash", "rasp", "rate", "rats",
                "rave", "raws", "rays", "raze", "razz", "read", "real", "ream", "reap", "rear", "recs", "redo", "reds", "reed",
                "reef", "reek", "reel", "refs", "reft", "rein", "rely", "rems", "rend", "reno", "rent", "reps", "resp", "rest",
                "ribs", "rice", "rich", "ride", "rids", "riel", "rife", "riff", "rift", "rigs", "rile", "rill", "rime", "rims",
                "rimy", "rind", "ring", "rink", "riot", "ripe", "rips", "rise", "risk", "rite", "ritz", "rive", "road", "roam",
                "roan", "roar", "robe", "robs", "rock", "rocs", "rode", "rods", "roes", "roil", "role", "roll", "rome", "romp",
                "roms", "rood", "roof", "rook", "room", "root", "rope", "ropy", "rosa", "rose", "rosy", "rote", "rots", "roue",
                "rout", "roux", "rove", "rows", "rube", "rubs", "ruby", "ruck", "rude", "rued", "ruer", "rues", "ruff", "rugs",
                "ruin", "rule", "rump", "rums", "rune", "rung", "runs", "runt", "ruse", "rush", "rusk", "rust", "ruth", "ruts",
                "sack", "sacs", "safe", "saga", "sage", "sago", "sags", "said", "sail", "sake", "sale", "salt", "same",
                "sand", "sane", "sang", "sank", "sans", "saps", "sari", "sash", "sass", "sate", "save", "sawn", "saws", "says",
                "scab", "scad", "scag", "scam", "scan", "scar", "scat", "scop", "scot", "scow", "scud", "scum", "scut",
                "seal", "seam", "sear", "seas", "seat", "secs", "sect", "seed", "seek", "seem", "seen", "seep", "seer", "sees",
                "self", "sell", "semi", "send", "sent", "sept", "sera", "serb", "sere", "serf", "sets", "sewn", "sews", "sexy",
                "shad", "shag", "shah", "sham", "shat", "shay", "shed", "shes", "shew", "shim", "shin", "ship", "shit", "shiv",
                "shmo", "shod", "shoe", "shoo", "shop", "shot", "show", "shun", "shut", "siam", "sibs", "sick", "sics",
                "side", "sift", "sigh", "sign", "sikh", "silk", "sill", "silo", "silt", "simp", "sine", "sing", "sinh", "sink",
                "sins", "sips", "sire", "sirs", "site", "sits", "situ", "size", "sizy", "skag", "skew", "skid", "skim",
                "skin", "skip", "skis", "skit", "slab", "slag", "slam", "slap", "slat", "slav", "slaw", "slay", "sled",
                "slew", "slid", "slim", "slip", "slit", "slob", "sloe", "slog", "slop", "slot", "slow", "slue", "slug", "slum",
                "slur", "slut", "smit", "smog", "smug", "smut", "snag", "snap", "snip", "snit", "snob", "snot", "snow", "snub",
                "snug", "soak", "soap", "soar", "sobs", "sock", "soda", "sods", "sofa", "soft", "soil", "sold", "sole", "soli",
                "solo", "soma", "some", "song", "sons", "soon", "soot", "sops", "sore", "sort", "sots", "soul", "soup", "sour",
                "sown", "sows", "span", "spar", "spas", "spat", "spay", "spec", "sped", "spew", "spic", "spin",
                "spit", "spot", "spry", "spud", "spun", "spur", "stab", "stag", "star", "stat", "stay", "stem", "step", "stet",
                "stew", "stir", "stoa", "stop", "stow", "stub", "stud", "stun", "stye", "styx", "subs", "such", "suck", "suds",
                "sued", "suer", "sues", "suet", "suez", "suit", "sulk", "sumo", "sump", "sums", "sung", "sunk", "suns",
                "sups", "supt", "sure", "surf", "swab", "swag", "swam", "swan", "swap", "swat", "sway", "swig", "swim",
                "swob", "swop", "swum", "sync", "syne", "tabs", "tabu", "tach", "tack", "taco", "tact", "tads", "tags", "tail",
                "take", "talc", "tale", "talk", "tall", "tame", "tamp", "tams", "tang", "tank", "tans", "tape", "taps",
                "tare", "tarn", "taro", "tarp", "tars", "tart", "task", "tass", "tate", "tats", "taut", "taws", "taxi", "teak",
                "teal", "team", "tear", "teas", "teat", "tech", "teds", "teed", "teem", "teen", "tees", "tell", "temp", "tend",
                "tens", "tent", "term", "tern", "terr", "test", "text", "thai", "than", "that", "thaw", "thee", "them", "then",
                "thew", "they", "thin", "this", "thor", "thou", "thud", "thug", "thus", "tick", "tics", "tide",
                "tidy", "tied", "tier", "ties", "tiff", "tike", "tile", "till", "tilt", "time", "tine", "ting", "tins", "tint",
                "tiny", "tipi", "tips", "tire", "tiro", "tits", "tnpk", "toad", "toed", "toes", "toff", "tofu", "toga", "togo",
                "togs", "toil", "toke", "told", "tole", "toll", "tomb", "tome", "toms", "tone", "tong", "tons", "tony", "took",
                "tool", "toot", "tope", "tops", "tora", "torc", "tore", "torn", "tors", "tort", "tory", "tosh", "toss",
                "tost", "tote", "toto", "tots", "tour", "tout", "town", "tows", "toys", "tram", "trap", "tray", "tree", "tref",
                "trek", "trey", "trig", "trim", "trio", "trip", "trod", "trop", "trot", "trow", "troy", "true", "tsar", "tuba",
                "tube", "tubs", "tuck", "tufa", "tuff", "tuft", "tugs", "tuna", "tune", "tuns", "tups", "turd", "turf", "turk",
                "turn", "tush", "tusk", "tuts", "tutu", "twas", "twat", "twig", "twin", "twit", "twos", "tyke", "type", "typo",
                "tyre", "tyro", "tzar", "ugli", "ugly", "ulva", "umps", "undo", "undy", "unto", "upon", "ural", "urge",
                "urns", "ursa", "used", "user", "uses", "utah", "vail", "vain", "vale", "vamp", "vane", "vans",
                "vary", "vase", "vast", "vats", "veal", "veda", "veep", "veer", "veil", "vein", "vela", "veld", "vend",
                "vent", "verb", "vert", "very", "vest", "veto", "vets", "vial", "vias", "vice", "vide", "vied", "vier",
                "vies", "view", "vile", "vims", "vine", "vino", "viny", "viol", "vips", "visa", "vise", "vita", "viva",
                "vive", "vivo", "voce", "void", "vole", "volt", "vote", "vows", "wack", "wacs", "wade", "wadi", "wads",
                "waft", "wage", "wags", "waif", "wail", "wain", "wait", "wake", "wale", "walk", "wall", "walt", "wand", "wane",
                "want", "ward", "ware", "warm", "warn", "warp", "wars", "wart", "wary", "wash", "wasp", "wast",
                "wats", "watt", "waul", "wave", "wavy", "waxy", "ways", "weak", "weal", "wean", "wear", "webs", "weds", "weed",
                "week", "ween", "weep", "weft", "weir", "weld", "well", "welt", "wend", "wens", "went", "wept", "were", "wert",
                "west", "wets", "wham", "whap", "what", "whee", "when", "whet", "whew", "whey", "whig", "whim", "whip", "whir",
                "whit", "whiz", "whoa", "whom", "wick", "wide", "wife", "wigs", "wild", "wile", "will", "wilt", "wily", "wind",
                "wine", "wing", "wink", "wino", "wins", "winy", "wipe", "wire", "wiry", "wise", "wish", "wisp", "with", "wits",
                "wive", "woad", "woes", "woke", "wold", "wolf", "womb", "wont", "wood", "woof", "wool", "woos", "wops", "word",
                "wore", "work", "worm", "worn", "wort", "wove", "wows", "wrap", "wren", "writ", "wyes", "yack", "yaks",
                "yale", "yams", "yang", "yank", "yaps", "yard", "yare", "yarn", "yawl", "yawn", "yawp", "yaws", "yeah", "year",
                "yeas", "yell", "yelp", "yens", "yeti", "yews", "yids", "yins", "yipe", "yips", "yoga", "yogi", "yoke", "yolk",
                "yond", "yoni", "yore", "york", "your", "yowl", "yows", "yuan", "yuks", "yule", "yurt", "zags", "zany", "zaps",
                "zeal", "zebu", "zeds", "zero", "zest", "zeta", "zigs", "zinc", "zing", "zion", "zips", "zone", "zoom", "zoos",
                "zori", "zulu", "zuni"};

        Random obj = new Random();
        int num = obj.nextInt(dictionary.length-1);
        String goalword = dictionary[num];
        char one = goalword.charAt(0);
        char two = goalword.charAt(1);
        char three = goalword.charAt(2);
        char four = goalword.charAt(3);

        String[] slotName = {"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
        int[] slotImages = {R.drawable.zero,R.drawable.zero,R.drawable.zero,R.drawable.zero, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron, R.drawable.zeron};
        int guesscount = 0;

        GridAdapter gridAdapter = new GridAdapter(Gamescreen.this, slotName, slotImages);
        binding.gridView.setAdapter(gridAdapter);
        //build static bar for user input on the bottom
        input.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                String text = input.getText().toString();
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    switch (keyCode)
                    {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:

                            for(int i = 0; i < dictionary.length; i++){
                                if(text == dictionary[i]){
                                    guess = text;
                                }
                                else{
                                    guess = "bear";
                                }
                            }
                            //guess = text;
                            input.setText("");
                            //makeDisplay(text + " added to list");
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }



        });

        //String guess = "bear"; //take input after verifying that it is in dictionary
        guesscount += 1;

        char first = guess.charAt(0);
        char second = guess.charAt(1);
        char third = guess.charAt(2);
        char fourth = guess.charAt(3);
        if(one == first){
            if(one == 'a'){
                slotImages[0] = R.drawable.a0;
                slotImages[guesscount*4] = R.drawable.a2;
            }
            else if(one == 'b'){
                slotImages[0] = R.drawable.b0;
                slotImages[guesscount*4] = R.drawable.b2;
            }
            else if(one == 'c'){
                slotImages[0] = R.drawable.c0;
                slotImages[guesscount*4] = R.drawable.c2;
            }
            else if(one == 'd'){
                slotImages[0] = R.drawable.d0;
                slotImages[guesscount*4] = R.drawable.d2;
            }
            else if(one == 'e'){
                slotImages[0] = R.drawable.e0;
                slotImages[guesscount*4] = R.drawable.e2;
            }
            else if(one == 'f'){
                slotImages[0] = R.drawable.f0;
                slotImages[guesscount*4] = R.drawable.f2;
            }
            else if(one == 'g'){
                slotImages[0] = R.drawable.g0;
                slotImages[guesscount*4] = R.drawable.g2;
            }
            else if(one == 'h'){
                slotImages[0] = R.drawable.h0;
                slotImages[guesscount*4] = R.drawable.h2;
            }
            else if(one == 'i'){
                slotImages[0] = R.drawable.i0;
                slotImages[guesscount*4] = R.drawable.i2;
            }
            else if(one == 'j'){
                slotImages[0] = R.drawable.j0;
                slotImages[guesscount*4] = R.drawable.j2;
            }
            else if(one == 'k'){
                slotImages[0] = R.drawable.k0;
                slotImages[guesscount*4] = R.drawable.k2;
            }
            else if(one == 'l'){
                slotImages[0] = R.drawable.l0;
                slotImages[guesscount*4] = R.drawable.l2;
            }
            else if(one == 'm'){
                slotImages[0] = R.drawable.m0;
                slotImages[guesscount*4] = R.drawable.m2;
            }
            else if(one == 'n'){
                slotImages[0] = R.drawable.n0;
                slotImages[guesscount*4] = R.drawable.n2;
            }
            else if(one == 'o'){
                slotImages[0] = R.drawable.o0;
                slotImages[guesscount*4] = R.drawable.o2;
            }
            else if(one == 'p'){
                slotImages[0] = R.drawable.p0;
                slotImages[guesscount*4] = R.drawable.p2;
            }
            else if(one == 'q'){
                slotImages[0] = R.drawable.q0;
                slotImages[guesscount*4] = R.drawable.q2;
            }
            else if(one == 'r'){
                slotImages[0] = R.drawable.r0;
                slotImages[guesscount*4] = R.drawable.r2;
            }
            else if(one == 's'){
                slotImages[0] = R.drawable.s0;
                slotImages[guesscount*4] = R.drawable.s2;
            }
            else if(one == 't'){
                slotImages[0] = R.drawable.t0;
                slotImages[guesscount*4] = R.drawable.t2;
            }
            else if(one == 'u'){
                slotImages[0] = R.drawable.u0;
                slotImages[guesscount*4] = R.drawable.u2;
            }
            else if(one == 'v'){
                slotImages[0] = R.drawable.v0;
                slotImages[guesscount*4] = R.drawable.v2;
            }
            else if(one == 'w'){
                slotImages[0] = R.drawable.w0;
                slotImages[guesscount*4] = R.drawable.w2;
            }
            else if(one == 'x'){
                slotImages[0] = R.drawable.x0;
                slotImages[guesscount*4] = R.drawable.x2;
            }
            else if(one == 'y'){
                slotImages[0] = R.drawable.y0;
                slotImages[guesscount*4] = R.drawable.y2;
            }
            else if(one == 'z'){
                slotImages[0] = R.drawable.z0;
                slotImages[guesscount*4] = R.drawable.z2;
            }
        }
        else if(first == two || first == three || first == four){
            if(first == 'a'){
                slotImages[guesscount*4] = R.drawable.a1;
            }
            else if(first == 'b'){
                slotImages[guesscount*4] = R.drawable.b1;
            }
            else if(first == 'c'){
                slotImages[guesscount*4] = R.drawable.c1;
            }
            else if(first == 'd'){
                slotImages[guesscount*4] = R.drawable.d1;
            }
            else if(first == 'e'){
                slotImages[guesscount*4] = R.drawable.e1;
            }
            else if(first == 'f'){
                slotImages[guesscount*4] = R.drawable.f1;
            }
            else if(first == 'g'){
                slotImages[guesscount*4] = R.drawable.g1;
            }
            else if(first == 'h'){
                slotImages[guesscount*4] = R.drawable.h1;
            }
            else if(first == 'i'){
                slotImages[guesscount*4] = R.drawable.i1;
            }
            else if(first == 'j'){
                slotImages[guesscount*4] = R.drawable.j1;
            }
            else if(first == 'k'){
                slotImages[guesscount*4] = R.drawable.k1;
            }
            else if(first == 'l'){
                slotImages[guesscount*4] = R.drawable.l1;
            }
            else if(first == 'm'){
                slotImages[guesscount*4] = R.drawable.m1;
            }
            else if(first == 'n'){
                slotImages[guesscount*4] = R.drawable.n1;
            }
            else if(first == 'o'){
                slotImages[guesscount*4] = R.drawable.o1;
            }
            else if(first == 'p'){
                slotImages[guesscount*4] = R.drawable.p1;
            }
            else if(first == 'q'){
                slotImages[guesscount*4] = R.drawable.q1;
            }
            else if(first == 'r'){
                slotImages[guesscount*4] = R.drawable.r1;
            }
            else if(first == 's'){
                slotImages[guesscount*4] = R.drawable.s1;
            }
            else if(first == 't'){
                slotImages[guesscount*4] = R.drawable.t1;
            }
            else if(first == 'u'){
                slotImages[guesscount*4] = R.drawable.u1;
            }
            else if(first == 'v'){
                slotImages[guesscount*4] = R.drawable.v1;
            }
            else if(first == 'w'){
                slotImages[guesscount*4] = R.drawable.w1;
            }
            else if(first == 'x'){
                slotImages[guesscount*4] = R.drawable.x1;
            }
            else if(first == 'y'){
                slotImages[guesscount*4] = R.drawable.y1;
            }
            else if(first == 'z'){
                slotImages[guesscount*4] = R.drawable.z1;
            }
        }
        else{
            if(first == 'a'){
                slotImages[guesscount*4] = R.drawable.a;
            }
            else if(first == 'b'){
                slotImages[guesscount*4] = R.drawable.b;
            }
            else if(first == 'c'){
                slotImages[guesscount*4] = R.drawable.c;
            }
            else if(first == 'd'){
                slotImages[guesscount*4] = R.drawable.d;
            }
            else if(first == 'e'){
                slotImages[guesscount*4] = R.drawable.e;
            }
            else if(first == 'f'){
                slotImages[guesscount*4] = R.drawable.f;
            }
            else if(first == 'g'){
                slotImages[guesscount*4] = R.drawable.g;
            }
            else if(first == 'h'){
                slotImages[guesscount*4] = R.drawable.h;
            }
            else if(first == 'i'){
                slotImages[guesscount*4] = R.drawable.i;
            }
            else if(first == 'j'){
                slotImages[guesscount*4] = R.drawable.j;
            }
            else if(first == 'k'){
                slotImages[guesscount*4] = R.drawable.k;
            }
            else if(first == 'l'){
                slotImages[guesscount*4] = R.drawable.l;
            }
            else if(first == 'm'){
                slotImages[guesscount*4] = R.drawable.m;
            }
            else if(first == 'n'){
                slotImages[guesscount*4] = R.drawable.n;
            }
            else if(first == 'o'){
                slotImages[guesscount*4] = R.drawable.o;
            }
            else if(first == 'p'){
                slotImages[guesscount*4] = R.drawable.p;
            }
            else if(first == 'q'){
                slotImages[guesscount*4] = R.drawable.q;
            }
            else if(first == 'r'){
                slotImages[guesscount*4] = R.drawable.r;
            }
            else if(first == 's'){
                slotImages[guesscount*4] = R.drawable.s;
            }
            else if(first == 't'){
                slotImages[guesscount*4] = R.drawable.t;
            }
            else if(first == 'u'){
                slotImages[guesscount*4] = R.drawable.u;
            }
            else if(first == 'v'){
                slotImages[guesscount*4] = R.drawable.v;
            }
            else if(first == 'w'){
                slotImages[guesscount*4] = R.drawable.w;
            }
            else if(first == 'x'){
                slotImages[guesscount*4] = R.drawable.x;
            }
            else if(first == 'y'){
                slotImages[guesscount*4] = R.drawable.y;
            }
            else if(first == 'z'){
                slotImages[guesscount*4] = R.drawable.z;
            }
        }
        if(two == second){
            if(two == 'a'){
                slotImages[1] = R.drawable.a0;
                slotImages[guesscount*4+1] = R.drawable.a2;
            }
            else if(two == 'b'){
                slotImages[1] = R.drawable.b0;
                slotImages[guesscount*4+1] = R.drawable.b2;
            }
            else if(two == 'c'){
                slotImages[1] = R.drawable.c0;
                slotImages[guesscount*4+1] = R.drawable.c2;
            }
            else if(two == 'd'){
                slotImages[1] = R.drawable.d0;
                slotImages[guesscount*4+1] = R.drawable.d2;
            }
            else if(two == 'e'){
                slotImages[1] = R.drawable.e0;
                slotImages[guesscount*4+1] = R.drawable.e2;
            }
            else if(two == 'f'){
                slotImages[1] = R.drawable.f0;
                slotImages[guesscount*4+1] = R.drawable.f2;
            }
            else if(two == 'g'){
                slotImages[1] = R.drawable.g0;
                slotImages[guesscount*4+1] = R.drawable.g2;
            }
            else if(two == 'h'){
                slotImages[1] = R.drawable.h0;
                slotImages[guesscount*4+1] = R.drawable.h2;
            }
            else if(two == 'i'){
                slotImages[1] = R.drawable.i0;
                slotImages[guesscount*4+1] = R.drawable.i2;
            }
            else if(two == 'j'){
                slotImages[1] = R.drawable.j0;
                slotImages[guesscount*4+1] = R.drawable.j2;
            }
            else if(two == 'k'){
                slotImages[1] = R.drawable.k0;
                slotImages[guesscount*4+1] = R.drawable.k2;
            }
            else if(two == 'l'){
                slotImages[1] = R.drawable.l0;
                slotImages[guesscount*4+1] = R.drawable.l2;
            }
            else if(two == 'm'){
                slotImages[1] = R.drawable.m0;
                slotImages[guesscount*4+1] = R.drawable.m2;
            }
            else if(two == 'n'){
                slotImages[1] = R.drawable.n0;
                slotImages[guesscount*4+1] = R.drawable.n2;
            }
            else if(two == 'o'){
                slotImages[1] = R.drawable.o0;
                slotImages[guesscount*4+1] = R.drawable.o2;
            }
            else if(two == 'p'){
                slotImages[1] = R.drawable.p0;
                slotImages[guesscount*4+1] = R.drawable.p2;
            }
            else if(two == 'q'){
                slotImages[1] = R.drawable.q0;
                slotImages[guesscount*4+1] = R.drawable.q2;
            }
            else if(two == 'r'){
                slotImages[1] = R.drawable.r0;
                slotImages[guesscount*4+1] = R.drawable.r2;
            }
            else if(two == 's'){
                slotImages[1] = R.drawable.s0;
                slotImages[guesscount*4+1] = R.drawable.s2;
            }
            else if(two == 't'){
                slotImages[1] = R.drawable.t0;
                slotImages[guesscount*4+1] = R.drawable.t2;
            }
            else if(two == 'u'){
                slotImages[1] = R.drawable.u0;
                slotImages[guesscount*4+1] = R.drawable.u2;
            }
            else if(two == 'v'){
                slotImages[1] = R.drawable.v0;
                slotImages[guesscount*4+1] = R.drawable.v2;
            }
            else if(two == 'w'){
                slotImages[1] = R.drawable.w0;
                slotImages[guesscount*4+1] = R.drawable.w2;
            }
            else if(two == 'x'){
                slotImages[1] = R.drawable.x0;
                slotImages[guesscount*4+1] = R.drawable.x2;
            }
            else if(two == 'y'){
                slotImages[1] = R.drawable.y0;
                slotImages[guesscount*4+1] = R.drawable.y2;
            }
            else if(two == 'z'){
                slotImages[1] = R.drawable.z0;
                slotImages[guesscount*4+1] = R.drawable.z2;
            }
        }
        else if(second == one || second == three || second == four){
            if(second == 'a'){
                slotImages[guesscount*4+1] = R.drawable.a1;
            }
            else if(second == 'b'){
                slotImages[guesscount*4+1] = R.drawable.b1;
            }
            else if(second == 'c'){
                slotImages[guesscount*4+1] = R.drawable.c1;
            }
            else if(second == 'd'){
                slotImages[guesscount*4+1] = R.drawable.d1;
            }
            else if(second == 'e'){
                slotImages[guesscount*4+1] = R.drawable.e1;
            }
            else if(second == 'f'){
                slotImages[guesscount*4+1] = R.drawable.f1;
            }
            else if(second == 'g'){
                slotImages[guesscount*4+1] = R.drawable.g1;
            }
            else if(second == 'h'){
                slotImages[guesscount*4+1] = R.drawable.h1;
            }
            else if(second == 'i'){
                slotImages[guesscount*4+1] = R.drawable.i1;
            }
            else if(second == 'j'){
                slotImages[guesscount*4+1] = R.drawable.j1;
            }
            else if(second == 'k'){
                slotImages[guesscount*4+1] = R.drawable.k1;
            }
            else if(second == 'l'){
                slotImages[guesscount*4+1] = R.drawable.l1;
            }
            else if(second == 'm'){
                slotImages[guesscount*4+1] = R.drawable.m1;
            }
            else if(second == 'n'){
                slotImages[guesscount*4+1] = R.drawable.n1;
            }
            else if(second == 'o'){
                slotImages[guesscount*4+1] = R.drawable.o1;
            }
            else if(second == 'p'){
                slotImages[guesscount*4+1] = R.drawable.p1;
            }
            else if(second == 'q'){
                slotImages[guesscount*4+1] = R.drawable.q1;
            }
            else if(second == 'r'){
                slotImages[guesscount*4+1] = R.drawable.r1;
            }
            else if(second == 's'){
                slotImages[guesscount*4+1] = R.drawable.s1;
            }
            else if(second == 't'){
                slotImages[guesscount*4+1] = R.drawable.t1;
            }
            else if(second == 'u'){
                slotImages[guesscount*4+1] = R.drawable.u1;
            }
            else if(second == 'v'){
                slotImages[guesscount*4+1] = R.drawable.v1;
            }
            else if(second == 'w'){
                slotImages[guesscount*4+1] = R.drawable.w1;
            }
            else if(second == 'x'){
                slotImages[guesscount*4+1] = R.drawable.x1;
            }
            else if(second == 'y'){
                slotImages[guesscount*4+1] = R.drawable.y1;
            }
            else if(second == 'z'){
                slotImages[guesscount*4+1] = R.drawable.z1;
            }
        }
        else{
            if(second == 'a'){
                slotImages[guesscount*4+1] = R.drawable.a;
            }
            else if(second == 'b'){
                slotImages[guesscount*4+1] = R.drawable.b;
            }
            else if(second == 'c'){
                slotImages[guesscount*4+1] = R.drawable.c;
            }
            else if(second == 'd'){
                slotImages[guesscount*4+1] = R.drawable.d;
            }
            else if(second == 'e'){
                slotImages[guesscount*4+1] = R.drawable.e;
            }
            else if(second == 'f'){
                slotImages[guesscount*4+1] = R.drawable.f;
            }
            else if(second == 'g'){
                slotImages[guesscount*4+1] = R.drawable.g;
            }
            else if(second == 'h'){
                slotImages[guesscount*4+1] = R.drawable.h;
            }
            else if(second == 'i'){
                slotImages[guesscount*4+1] = R.drawable.i;
            }
            else if(second == 'j'){
                slotImages[guesscount*4+1] = R.drawable.j;
            }
            else if(second == 'k'){
                slotImages[guesscount*4+1] = R.drawable.k;
            }
            else if(second == 'l'){
                slotImages[guesscount*4+1] = R.drawable.l;
            }
            else if(second == 'm'){
                slotImages[guesscount*4+1] = R.drawable.m;
            }
            else if(second == 'n'){
                slotImages[guesscount*4+1] = R.drawable.n;
            }
            else if(second == 'o'){
                slotImages[guesscount*4+1] = R.drawable.o;
            }
            else if(second == 'p'){
                slotImages[guesscount*4+1] = R.drawable.p;
            }
            else if(second == 'q'){
                slotImages[guesscount*4+1] = R.drawable.q;
            }
            else if(second == 'r'){
                slotImages[guesscount*4+1] = R.drawable.r;
            }
            else if(second == 's'){
                slotImages[guesscount*4+1] = R.drawable.s;
            }
            else if(second == 't'){
                slotImages[guesscount*4+1] = R.drawable.t;
            }
            else if(second == 'u'){
                slotImages[guesscount*4+1] = R.drawable.u;
            }
            else if(second == 'v'){
                slotImages[guesscount*4+1] = R.drawable.v;
            }
            else if(second == 'w'){
                slotImages[guesscount*4+1] = R.drawable.w;
            }
            else if(second == 'x'){
                slotImages[guesscount*4+1] = R.drawable.x;
            }
            else if(second == 'y'){
                slotImages[guesscount*4+1] = R.drawable.y;
            }
            else if(second == 'z'){
                slotImages[guesscount*4+1] = R.drawable.z;
            }
        }
        if(three == third){
            if(three == 'a'){
                slotImages[2] = R.drawable.a0;
                slotImages[guesscount*4+2] = R.drawable.a2;
            }
            else if(three == 'b'){
                slotImages[2] = R.drawable.b0;
                slotImages[guesscount*4+2] = R.drawable.b2;
            }
            else if(three == 'c'){
                slotImages[2] = R.drawable.c0;
                slotImages[guesscount*4+2] = R.drawable.c2;
            }
            else if(three == 'd'){
                slotImages[2] = R.drawable.d0;
                slotImages[guesscount*4+2] = R.drawable.d2;
            }
            else if(three == 'e'){
                slotImages[2] = R.drawable.e0;
                slotImages[guesscount*4+2] = R.drawable.e2;
            }
            else if(three == 'f'){
                slotImages[2] = R.drawable.f0;
                slotImages[guesscount*4+2] = R.drawable.f2;
            }
            else if(three == 'g'){
                slotImages[2] = R.drawable.g0;
                slotImages[guesscount*4+2] = R.drawable.g2;
            }
            else if(three == 'h'){
                slotImages[2] = R.drawable.h0;
                slotImages[guesscount*4+2] = R.drawable.h2;
            }
            else if(three == 'i'){
                slotImages[2] = R.drawable.i0;
                slotImages[guesscount*4+2] = R.drawable.i2;
            }
            else if(three == 'j'){
                slotImages[2] = R.drawable.j0;
                slotImages[guesscount*4+2] = R.drawable.j2;
            }
            else if(three == 'k'){
                slotImages[2] = R.drawable.k0;
                slotImages[guesscount*4+2] = R.drawable.k2;
            }
            else if(three == 'l'){
                slotImages[2] = R.drawable.l0;
                slotImages[guesscount*4+2] = R.drawable.l2;
            }
            else if(three == 'm'){
                slotImages[2] = R.drawable.m0;
                slotImages[guesscount*4+2] = R.drawable.m2;
            }
            else if(three == 'n'){
                slotImages[2] = R.drawable.n0;
                slotImages[guesscount*4+2] = R.drawable.n2;
            }
            else if(three == 'o'){
                slotImages[2] = R.drawable.o0;
                slotImages[guesscount*4+2] = R.drawable.o2;
            }
            else if(three == 'p'){
                slotImages[2] = R.drawable.p0;
                slotImages[guesscount*4+2] = R.drawable.p2;
            }
            else if(three == 'q'){
                slotImages[2] = R.drawable.q0;
                slotImages[guesscount*4+2] = R.drawable.q2;
            }
            else if(three == 'r'){
                slotImages[2] = R.drawable.r0;
                slotImages[guesscount*4+2] = R.drawable.r2;
            }
            else if(three == 's'){
                slotImages[2] = R.drawable.s0;
                slotImages[guesscount*4+2] = R.drawable.s2;
            }
            else if(three == 't'){
                slotImages[2] = R.drawable.t0;
                slotImages[guesscount*4+2] = R.drawable.t2;
            }
            else if(three == 'u'){
                slotImages[2] = R.drawable.u0;
                slotImages[guesscount*4+2] = R.drawable.u2;
            }
            else if(three == 'v'){
                slotImages[2] = R.drawable.v0;
                slotImages[guesscount*4+2] = R.drawable.v2;
            }
            else if(three == 'w'){
                slotImages[2] = R.drawable.w0;
                slotImages[guesscount*4+2] = R.drawable.w2;
            }
            else if(three == 'x'){
                slotImages[2] = R.drawable.x0;
                slotImages[guesscount*4+2] = R.drawable.x2;
            }
            else if(three == 'y'){
                slotImages[2] = R.drawable.y0;
                slotImages[guesscount*4+2] = R.drawable.y2;
            }
            else if(three == 'z'){
                slotImages[2] = R.drawable.z0;
                slotImages[guesscount*4+2] = R.drawable.z2;
            }
        }
        else if(third == one || third == two || third == four){
            if(third == 'a'){
                slotImages[guesscount*4+2] = R.drawable.a1;
            }
            else if(third == 'b'){
                slotImages[guesscount*4+2] = R.drawable.b1;
            }
            else if(third == 'c'){
                slotImages[guesscount*4+2] = R.drawable.c1;
            }
            else if(third == 'd'){
                slotImages[guesscount*4+2] = R.drawable.d1;
            }
            else if(third == 'e'){
                slotImages[guesscount*4+2] = R.drawable.e1;
            }
            else if(third == 'f'){
                slotImages[guesscount*4+2] = R.drawable.f1;
            }
            else if(third == 'g'){
                slotImages[guesscount*4+2] = R.drawable.g1;
            }
            else if(third == 'h'){
                slotImages[guesscount*4+2] = R.drawable.h1;
            }
            else if(third == 'i'){
                slotImages[guesscount*4+2] = R.drawable.i1;
            }
            else if(third == 'j'){
                slotImages[guesscount*4+2] = R.drawable.j1;
            }
            else if(third == 'k'){
                slotImages[guesscount*4+2] = R.drawable.k1;
            }
            else if(third == 'l'){
                slotImages[guesscount*4+2] = R.drawable.l1;
            }
            else if(third == 'm'){
                slotImages[guesscount*4+2] = R.drawable.m1;
            }
            else if(third == 'n'){
                slotImages[guesscount*4+2] = R.drawable.n1;
            }
            else if(third == 'o'){
                slotImages[guesscount*4+2] = R.drawable.o1;
            }
            else if(third == 'p'){
                slotImages[guesscount*4+2] = R.drawable.p1;
            }
            else if(third == 'q'){
                slotImages[guesscount*4+2] = R.drawable.q1;
            }
            else if(third == 'r'){
                slotImages[guesscount*4+2] = R.drawable.r1;
            }
            else if(third == 's'){
                slotImages[guesscount*4+2] = R.drawable.s1;
            }
            else if(third == 't'){
                slotImages[guesscount*4+2] = R.drawable.t1;
            }
            else if(third == 'u'){
                slotImages[guesscount*4+2] = R.drawable.u1;
            }
            else if(third == 'v'){
                slotImages[guesscount*4+2] = R.drawable.v1;
            }
            else if(third == 'w'){
                slotImages[guesscount*4+2] = R.drawable.w1;
            }
            else if(third == 'x'){
                slotImages[guesscount*4+2] = R.drawable.x1;
            }
            else if(third == 'y'){
                slotImages[guesscount*4+2] = R.drawable.y1;
            }
            else if(third == 'z'){
                slotImages[guesscount*4+2] = R.drawable.z1;
            }
        }
        else{
            if(third == 'a'){
                slotImages[guesscount*4+2] = R.drawable.a;
            }
            else if(third == 'b'){
                slotImages[guesscount*4+2] = R.drawable.b;
            }
            else if(third == 'c'){
                slotImages[guesscount*4+2] = R.drawable.c;
            }
            else if(third == 'd'){
                slotImages[guesscount*4+2] = R.drawable.d;
            }
            else if(third == 'e'){
                slotImages[guesscount*4+2] = R.drawable.e;
            }
            else if(third == 'f'){
                slotImages[guesscount*4+2] = R.drawable.f;
            }
            else if(third == 'g'){
                slotImages[guesscount*4+2] = R.drawable.g;
            }
            else if(third == 'h'){
                slotImages[guesscount*4+2] = R.drawable.h;
            }
            else if(third == 'i'){
                slotImages[guesscount*4+2] = R.drawable.i;
            }
            else if(third == 'j'){
                slotImages[guesscount*4+2] = R.drawable.j;
            }
            else if(third == 'k'){
                slotImages[guesscount*4+2] = R.drawable.k;
            }
            else if(third == 'l'){
                slotImages[guesscount*4+2] = R.drawable.l;
            }
            else if(third == 'm'){
                slotImages[guesscount*4+2] = R.drawable.m;
            }
            else if(third == 'n'){
                slotImages[guesscount*4+2] = R.drawable.n;
            }
            else if(third == 'o'){
                slotImages[guesscount*4+2] = R.drawable.o;
            }
            else if(third == 'p'){
                slotImages[guesscount*4+2] = R.drawable.p;
            }
            else if(third == 'q'){
                slotImages[guesscount*4+2] = R.drawable.q;
            }
            else if(third == 'r'){
                slotImages[guesscount*4+2] = R.drawable.r;
            }
            else if(third == 's'){
                slotImages[guesscount*4+2] = R.drawable.s;
            }
            else if(third == 't'){
                slotImages[guesscount*4+2] = R.drawable.t;
            }
            else if(third == 'u'){
                slotImages[guesscount*4+2] = R.drawable.u;
            }
            else if(third == 'v'){
                slotImages[guesscount*4+2] = R.drawable.v;
            }
            else if(third == 'w'){
                slotImages[guesscount*4+2] = R.drawable.w;
            }
            else if(third == 'x'){
                slotImages[guesscount*4+2] = R.drawable.x;
            }
            else if(third == 'y'){
                slotImages[guesscount*4+2] = R.drawable.y;
            }
            else if(third == 'z'){
                slotImages[guesscount*4+2] = R.drawable.z;
            }
        }
        if(four == fourth){
            if(four == 'a'){
                slotImages[3] = R.drawable.a0;
                slotImages[guesscount*4+3] = R.drawable.a2;
            }
            else if(four == 'b'){
                slotImages[3] = R.drawable.b0;
                slotImages[guesscount*4+3] = R.drawable.b2;
            }
            else if(four == 'c'){
                slotImages[3] = R.drawable.c0;
                slotImages[guesscount*4+3] = R.drawable.c2;
            }
            else if(four == 'd'){
                slotImages[3] = R.drawable.d0;
                slotImages[guesscount*4+3] = R.drawable.d2;
            }
            else if(four == 'e'){
                slotImages[3] = R.drawable.e0;
                slotImages[guesscount*4+3] = R.drawable.e2;
            }
            else if(four == 'f'){
                slotImages[3] = R.drawable.f0;
                slotImages[guesscount*4+3] = R.drawable.f2;
            }
            else if(four == 'g'){
                slotImages[3] = R.drawable.g0;
                slotImages[guesscount*4+3] = R.drawable.g2;
            }
            else if(four == 'h'){
                slotImages[3] = R.drawable.h0;
                slotImages[guesscount*4+3] = R.drawable.h2;
            }
            else if(four == 'i'){
                slotImages[3] = R.drawable.i0;
                slotImages[guesscount*4+3] = R.drawable.i2;
            }
            else if(four == 'j'){
                slotImages[3] = R.drawable.j0;
                slotImages[guesscount*4+3] = R.drawable.j2;
            }
            else if(four == 'k'){
                slotImages[3] = R.drawable.k0;
                slotImages[guesscount*4+3] = R.drawable.k2;
            }
            else if(four == 'l'){
                slotImages[3] = R.drawable.l0;
                slotImages[guesscount*4+3] = R.drawable.l2;
            }
            else if(four == 'm'){
                slotImages[3] = R.drawable.m0;
                slotImages[guesscount*4+3] = R.drawable.m2;
            }
            else if(four == 'n'){
                slotImages[3] = R.drawable.n0;
                slotImages[guesscount*4+3] = R.drawable.n2;
            }
            else if(four == 'o'){
                slotImages[3] = R.drawable.o0;
                slotImages[guesscount*4+3] = R.drawable.o2;
            }
            else if(four == 'p'){
                slotImages[3] = R.drawable.p0;
                slotImages[guesscount*4+3] = R.drawable.p2;
            }
            else if(four == 'q'){
                slotImages[3] = R.drawable.q0;
                slotImages[guesscount*4+3] = R.drawable.q2;
            }
            else if(four == 'r'){
                slotImages[3] = R.drawable.r0;
                slotImages[guesscount*4+3] = R.drawable.r2;
            }
            else if(four == 's'){
                slotImages[3] = R.drawable.s0;
                slotImages[guesscount*4+3] = R.drawable.s2;
            }
            else if(four == 't'){
                slotImages[3] = R.drawable.t0;
                slotImages[guesscount*4+3] = R.drawable.t2;
            }
            else if(four == 'u'){
                slotImages[3] = R.drawable.u0;
                slotImages[guesscount*4+3] = R.drawable.u2;
            }
            else if(four == 'v'){
                slotImages[3] = R.drawable.v0;
                slotImages[guesscount*4+3] = R.drawable.v2;
            }
            else if(four == 'w'){
                slotImages[3] = R.drawable.w0;
                slotImages[guesscount*4+3] = R.drawable.w2;
            }
            else if(four == 'x'){
                slotImages[3] = R.drawable.x0;
                slotImages[guesscount*4+3] = R.drawable.x2;
            }
            else if(four == 'y'){
                slotImages[3] = R.drawable.y0;
                slotImages[guesscount*4+3] = R.drawable.y2;
            }
            else if(four == 'z'){
                slotImages[3] = R.drawable.z0;
                slotImages[guesscount*4+3] = R.drawable.z2;
            }
        }
        else if(fourth == one || fourth == two || fourth == three){
            if(fourth == 'a'){
                slotImages[guesscount*4+3] = R.drawable.a1;
            }
            else if(fourth == 'b'){
                slotImages[guesscount*4+3] = R.drawable.b1;
            }
            else if(fourth == 'c'){
                slotImages[guesscount*4+3] = R.drawable.c1;
            }
            else if(fourth == 'd'){
                slotImages[guesscount*4+3] = R.drawable.d1;
            }
            else if(fourth == 'e'){
                slotImages[guesscount*4+3] = R.drawable.e1;
            }
            else if(fourth == 'f'){
                slotImages[guesscount*4+3] = R.drawable.f1;
            }
            else if(fourth == 'g'){
                slotImages[guesscount*4+3] = R.drawable.g1;
            }
            else if(fourth == 'h'){
                slotImages[guesscount*4+3] = R.drawable.h1;
            }
            else if(fourth == 'i'){
                slotImages[guesscount*4+3] = R.drawable.i1;
            }
            else if(fourth == 'j'){
                slotImages[guesscount*4+3] = R.drawable.j1;
            }
            else if(fourth == 'k'){
                slotImages[guesscount*4+3] = R.drawable.k1;
            }
            else if(fourth == 'l'){
                slotImages[guesscount*4+3] = R.drawable.l1;
            }
            else if(fourth == 'm'){
                slotImages[guesscount*4+3] = R.drawable.m1;
            }
            else if(fourth == 'n'){
                slotImages[guesscount*4+3] = R.drawable.n1;
            }
            else if(fourth == 'o'){
                slotImages[guesscount*4+3] = R.drawable.o1;
            }
            else if(fourth == 'p'){
                slotImages[guesscount*4+3] = R.drawable.p1;
            }
            else if(fourth == 'q'){
                slotImages[guesscount*4+3] = R.drawable.q1;
            }
            else if(fourth == 'r'){
                slotImages[guesscount*4+3] = R.drawable.r1;
            }
            else if(fourth == 's'){
                slotImages[guesscount*4+3] = R.drawable.s1;
            }
            else if(fourth == 't'){
                slotImages[guesscount*4+3] = R.drawable.t1;
            }
            else if(fourth == 'u'){
                slotImages[guesscount*4+3] = R.drawable.u1;
            }
            else if(fourth == 'v'){
                slotImages[guesscount*4+3] = R.drawable.v1;
            }
            else if(fourth == 'w'){
                slotImages[guesscount*4+3] = R.drawable.w1;
            }
            else if(fourth == 'x'){
                slotImages[guesscount*4+3] = R.drawable.x1;
            }
            else if(fourth == 'y'){
                slotImages[guesscount*4+3] = R.drawable.y1;
            }
            else if(fourth == 'z'){
                slotImages[guesscount*4+3] = R.drawable.z1;
            }
        }
        else{
            if(fourth == 'a'){
                slotImages[guesscount*4+3] = R.drawable.a;
            }
            else if(fourth == 'b'){
                slotImages[guesscount*4+3] = R.drawable.b;
            }
            else if(fourth == 'c'){
                slotImages[guesscount*4+3] = R.drawable.c;
            }
            else if(fourth == 'd'){
                slotImages[guesscount*4+3] = R.drawable.d;
            }
            else if(fourth == 'e'){
                slotImages[guesscount*4+3] = R.drawable.e;
            }
            else if(fourth == 'f'){
                slotImages[guesscount*4+3] = R.drawable.f;
            }
            else if(fourth == 'g'){
                slotImages[guesscount*4+3] = R.drawable.g;
            }
            else if(fourth == 'h'){
                slotImages[guesscount*4+3] = R.drawable.h;
            }
            else if(fourth == 'i'){
                slotImages[guesscount*4+3] = R.drawable.i;
            }
            else if(fourth == 'j'){
                slotImages[guesscount*4+3] = R.drawable.j;
            }
            else if(fourth == 'k'){
                slotImages[guesscount*4+3] = R.drawable.k;
            }
            else if(fourth == 'l'){
                slotImages[guesscount*4+3] = R.drawable.l;
            }
            else if(fourth == 'm'){
                slotImages[guesscount*4+3] = R.drawable.m;
            }
            else if(fourth == 'n'){
                slotImages[guesscount*4+3] = R.drawable.n;
            }
            else if(fourth == 'o'){
                slotImages[guesscount*4+3] = R.drawable.o;
            }
            else if(fourth == 'p'){
                slotImages[guesscount*4+3] = R.drawable.p;
            }
            else if(fourth == 'q'){
                slotImages[guesscount*4+3] = R.drawable.q;
            }
            else if(fourth == 'r'){
                slotImages[guesscount*4+3] = R.drawable.r;
            }
            else if(fourth == 's'){
                slotImages[guesscount*4+3] = R.drawable.s;
            }
            else if(fourth == 't'){
                slotImages[guesscount*4+3] = R.drawable.t;
            }
            else if(fourth == 'u'){
                slotImages[guesscount*4+3] = R.drawable.u;
            }
            else if(fourth == 'v'){
                slotImages[guesscount*4+3] = R.drawable.v;
            }
            else if(fourth == 'w'){
                slotImages[guesscount*4+3] = R.drawable.w;
            }
            else if(fourth == 'x'){
                slotImages[guesscount*4+3] = R.drawable.x;
            }
            else if(fourth == 'y'){
                slotImages[guesscount*4+3] = R.drawable.y;
            }
            else if(fourth == 'z'){
                slotImages[guesscount*4+3] = R.drawable.z;
            }
        }
        if(slotImages[0] != R.drawable.zero && slotImages[1] != R.drawable.zero && slotImages[2] != R.drawable.zero && slotImages[3] != R.drawable.zero){
            Intent intent = new Intent(Gamescreen.this, Winscreen.class);
            startActivity(intent);
        }
        else if(guesscount == 8){
            Intent intent = new Intent(Gamescreen.this, Losescreen.class);
            startActivity(intent);
        }



//        binding.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Toast.makeText(Gamescreen.this,"You Clicked on "+ slotName[position],Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }

}
