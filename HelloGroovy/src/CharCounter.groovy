/**
 * �t�@�C���ɏo�����镶�����Ƃ̐����J�E���g
 * 
 * @author hiranasu

 */
class CharCounter {
	
	public static void main(String[] args) {
		
		def map = [:]
		
		new File(args[0]).eachLine {
			it.chars.each {
				map[it] = map[it] == null ? 1 : map[it] + 1
			}
		}
		
		map.entrySet().sort {it.value}.each {
			println "${it.key} : ${it.value}"
		}
		
	}
}
