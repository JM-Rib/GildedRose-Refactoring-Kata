# Assignment 2: Gilded Rose Refactoring Kata

This repository is an attempt at the ["Gilded Rose Kata"](https://github.com/emilybache/GildedRose-Refactoring-Kata). It was made at Poznan university of technology as part of a Software evolution and maintenance class.

## Group:
- Jean-Marin Ribaric
- Joao Duarte

## Changes made:

The code was changed to make the item class into a super class from which all other items inherit from. All other items have their own override of the methods related to how the quality evolves over time.
The following items have their own classes:
- AgedBrieItem
- ElixirOTMongoose
- TAFKAL80ETC
- DexterityVest
- HandOfRagnaros
- ManaCake

After refactoring the code, we made tests to verify it's behaviour.

### Tests

We then took note the expected behaviour of the items in terms of the way the quality changes. We then made tests to make sure the code we wrote behaves in the expected way. The tests are made in ["TexttestFixture.java"](https://github.com/JM-Rib/GildedRose-Refactoring-Kata/blob/main/Java/src/main/java/com/gildedrose/TexttestFixture.java) They use Junit asserts for testing.
