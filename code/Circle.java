class Circle
{

  private PVector position;
  private float radius;

  /* Constructor definition */
  public Circle(PVector position, float radius)
  {
    this.position = position;
    this.radius = radius;
  }

  /* Function definition */
  public void show()
  {
    pushMatrix();
    translate(this.position.x, this.position.y);
    
    noFill();
    stroke(180, 180);
    circle(0, 0, this.radius);
    popMatrix();
  }
}
