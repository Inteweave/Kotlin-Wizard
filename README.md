# Kotlin-Wizard
Pattern used for set-by-step instructions. Sometimes called a Wizard or Assistant.

## Concept
Inteweave has developed many self-install kits since 2004 and has used this method for all of them. It has been coded in C++, Actionscript, Swift, Kotlin, Java and Objective-C.

What we are aiming for is to have each screen and it's coordinator independent of any other screen. The UX flow shows how the screens should be linked and the wizard code represents that directly. The order of the steps can be coded or input as a data file. The wizard definition is *Viewing screen X, on event Y, go to screen Z*

For example, we have the following steps to choose a snack:
```
- choose snack
   - icecream
     - scoop
     - soft serve
       - choc dip
       - sprinkles
   - nuts
```
The UX flow is coded as:
```
// from screen, on event, navigate to screen
ScreenNavigation(SnacksScreen.SELECT_TYPE, SnacksEvent.ICE_CREAM_CHOSEN, SnacksScreen.ICE_CREAM_SERVE),

ScreenNavigation(SnacksScreen.ICE_CREAM_SERVE, SnacksEvent.SOFT_SERVE_CHOSEN, SnacksScreen.CHOOSE_TOPPING),
ScreenNavigation(SnacksScreen.ICE_CREAM_SERVE, SnacksEvent.SCOOP_CHOSEN, SnacksScreen.SCOOP),

ScreenNavigation(SnacksScreen.CHOOSE_TOPPING, SnacksEvent.CHOC_DIP_CHOSEN, SnacksScreen.SOFT_SERVE_CHOC_DIP),
ScreenNavigation(SnacksScreen.CHOOSE_TOPPING, SnacksEvent.SPRINKLES_CHOSEN, SnacksScreen.SOFT_SERVE_SPRINKLES),

ScreenNavigation(SnacksScreen.SELECT_TYPE, SnacksEvent.NUTS_CHOSEN, SnacksScreen.NUTS)
```
