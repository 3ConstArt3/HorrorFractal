class HorrorFractal
{

  private Integer currentNumber;
  private ArrayList<Integer> sequence;
  private ArrayList<Circle> horrorCircles;

  /* Constructor definition */
  public HorrorFractal()
  {
    this.currentNumber = 0;

    this.sequence = new ArrayList<Integer>();
    this.sequence.add(0);

    this.horrorCircles = new ArrayList<Circle>();
    var position = new PVector();
    var radius = 0;
    this.horrorCircles.add(new Circle(position, radius));
  }

  /* Function definition */
  public void generate()
  {
    var sequenceCanBeGenerated = (this.currentNumber > 0);
    if (sequenceCanBeGenerated)
    {
      var previousSequenceValue = this.sequence.get(this.currentNumber - 1);
      var difference = previousSequenceValue - this.currentNumber;

      var valueLiesInSequence = this.previouslyExisted(this.currentNumber, difference);
      var goForward = (difference < 0 || valueLiesInSequence);
      var nextSequenceValue = (goForward ? difference + 2 * this.currentNumber : difference);
      this.sequence.add(nextSequenceValue);

      var currentSequenceValue = this.sequence.get(this.currentNumber);
      var posX = (previousSequenceValue + currentSequenceValue) / 2;
      var position = new PVector(posX, 0);
      var radius = currentSequenceValue - previousSequenceValue;
      this.horrorCircles.add(new Circle(position, radius));
    }

    this.currentNumber++;
  }

  private boolean previouslyExisted(int indexLimit, int number)
  {
    for (int k = 0; k < indexLimit; k++)
    {
      var numberExists = (number == this.sequence.get(k));
      if (numberExists) return true;
    }
    return false;
  }

  public void show()
  {
    pushMatrix();
    translate(0, height / 2);

    if (this.horrorCircles != null && this.horrorCircles.size() != 0)
    {
      for (var horrorCircle : this.horrorCircles)
        horrorCircle.show();
    }

    popMatrix();
  }
}
