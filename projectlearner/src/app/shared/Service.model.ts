export class User{

  constructor(
    public  name:string,
    public email:string,
    public password:string,
    public phone:number
  ){}

}
export class TechSuppModel {
  constructor(
    private title:string,
    private subject:string,
    private content:string
  ){}

}
