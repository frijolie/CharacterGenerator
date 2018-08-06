package com.frijolie.dcc.model.inventory;

import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * <p>Equipment represents a single piece of equipment in the application.</p>
 *
 * <p>Equipment represents supplies that can be purchased at a shop from a merchant. It could be,
 * for example, a lantern or a backpack. Some equipment will have additional notes or facts that may
 * need to be displayed in the user interface. Therefore, Equipment extends {@link Item} and
 * contains a List where these notes about the equipment can be saved.</p>
 *
 * <p>A zero level DCC character is given a random piece of equipment to start their game. This
 * does not include their trade tools granted by their occupation.</p>
 *
 * <p>Note: ALL COST VALUES ARE SET IN COPPER DENOMINATION</p>
 *
 * @author Frijolie
 * @version 0.1
 * @see Item
 */
public class Equipment extends Item {

  /**
   * List of notes about this piece of equipment
   */
  private ObservableList<String> notes;

  /**
   * For deserialization, a zero-arg constructor.
   */
  private Equipment() {
  }

  /**
   * Constructor. Allows for a name and costInCopper to be set
   *
   * @param name the name to be set
   * @param costInCopper the cost to be set
   */
  public Equipment(String name, double costInCopper) {
    super(name);
    notes = FXCollections.observableArrayList();
    this.costInCopper = costInCopper;
  }

  /**
   * Returns an unmodifiable observable list of all the notes in regard to this piece of equipment
   *
   * @return a list of all notes.
   */
  public ObservableList<String> getNotes() {
    return FXCollections.unmodifiableObservableList(notes);
  }

  /**
   * Mutator method to add a note to this piece of equipment. Is only added if it doesn't already
   * exist.
   *
   * @throws NullPointerException if the note is null
   */
  public void addNotes(String note) {
    Objects.requireNonNull(note,
        "You must pass a note to be added to the list. It cannot be null");
    if (notes.stream().noneMatch(s -> s.equals(note))) {
      notes.add(note);
    }
  }

  @Override
  public String toString() {
    return name;
  }
}