import { InputProps } from "../interfaces/InputProps";
export function Input({ label, value, onChange, type}: InputProps) {
    return (
    <div className="input-box">
      <label>{label}</label>
      <input
        type={type}
        value={value as string}
        onChange={onChange}/>
    </div>
  );
};
