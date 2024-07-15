import ImageBox from "../ImageBox/ImageBox";
import UlBox from "../UlBox/UlBox";
const TableBox = () => {
    return (
    <div className="tableBox" style={{display:"flex", justifyContent:"center"}}>
      <table border='1'>
        <tr>
          <th colspan="3"></th>
        </tr>
        <tr>
          <th>seq</th>
          <th>name</th>
          <th>price</th>
        </tr>
        <tr>
          <th>1</th>
          <th>apple</th>
          <th>2000</th>
        </tr>
      </table>
      <ImageBox/>
      <UlBox/>
    </div>);
    
  }

  export default TableBox;