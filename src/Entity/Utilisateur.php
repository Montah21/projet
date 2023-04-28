<?php

namespace App\Entity;

use App\Repository\UtilisateurRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
use Symfony\Component\Validator\Constraints\Email;

#[ORM\Entity(repositoryClass: UtilisateurRepository::class)]
class Utilisateur
{
    #[ORM\Id]
    #[ORM\GeneratedValue]
    #[ORM\Column]
    private ?int $id = null;

    #[ORM\Column]
    /**
 *  @Assert\NotBlank(message="Le champ cin est obligatoire")
 *  @Assert\Regex(
 *     pattern="/^\d{8}$/",
 *     message="Le champ cin doit contenir 8 chiffres."
 * )
 */
    private ?int $cin = null;
    

    #[ORM\Column(length: 60)]
    /** 
    *
     * @Assert\Type("string",message="The value {{ value }} is not a valid {{ type }}.")
     *    @Assert\NotBlank(message="Nom taille entre [3..20]")
     *  @Assert\Length(
     *      min = 3,
     *      max = 20,
     *      minMessage = "le nom doit etre superieur a  3  characters ",
     *      maxMessage = "le nom doit etre inferieur a  20  characters"
     * )
     *  @Assert\Regex(
     *     pattern="/^[a-zA-Z]+$/",
     *     message="Ce champ ne doit contenir que des caractères alphabétiques."
     * )
     *  
    */
    private ?string $nom = null;

    #[ORM\Column(length: 80)]
    /** 
    *
     * @Assert\Type("string",message="The value {{ value }} is not a valid {{ type }}.")
     *    @Assert\NotBlank(message="Nom taille entre [3..20]")
     *  @Assert\Length(
     *      min = 3,
     *      max = 20,
     *      minMessage = "le nom doit etre superieur a  3  characters ",
     *      maxMessage = "le nom doit etre inferieur a  20  characters"
     * )
     *  @Assert\Regex(
     *     pattern="/^[a-zA-Z]+$/",
     *     message="Ce champ ne doit contenir que des caractères alphabétiques."
     * )
     *  
    */
    private ?string $prenom = null;

    #[ORM\Column(length: 200)]
    /**
 * @Assert\Email(
 *     message = "L'adresse e-mail '{{ value }}' n'est pas valide.",
 
 * )
 */

    private ?string $mail = null;

    #[ORM\Column(length: 220)]
      /**
 *  @Assert\NotBlank(message="Le champ password est obligatoire")
 * )
 */
    private ?string $password = null;

    #[ORM\Column(length: 210)]
      /**
 *  @Assert\NotBlank(message="Le champ password est obligatoire")
 * )
 */
    private ?string $role = null;

    #[ORM\Column]
     /**
 *  @Assert\NotBlank(message="Le champ role est obligatoire")
 * )
 */
    private ?int $tel = null;

    #[ORM\OneToMany(mappedBy: 'user', targetEntity: Avis::class)]
    private Collection $avis;

    public function __construct()
    {
        $this->avis = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getCin(): ?int
    {
        return $this->cin;
    }

    public function setCin(int $cin): self
    {
        $this->cin = $cin;

        return $this;
    }

    public function getNom(): ?string
    {
        return $this->nom;
    }

    public function setNom(string $nom): self
    {
        $this->nom = $nom;

        return $this;
    }

    public function getPrenom(): ?string
    {
        return $this->prenom;
    }

    public function setPrenom(string $prenom): self
    {
        $this->prenom = $prenom;

        return $this;
    }

    public function getMail(): ?string
    {
        return $this->mail;
    }

    public function setMail(string $mail): self
    {
        $this->mail = $mail;

        return $this;
    }

    public function getPassword(): ?string
    {
        return $this->password;
    }

    public function setPassword(string $password): self
    {
        $this->password = $password;

        return $this;
    }

    public function getRole(): ?string
    {
        return $this->role;
    }

    public function setRole(string $role): self
    {
        $this->role = $role;

        return $this;
    }

    public function getTel(): ?int
    {
        return $this->tel;
    }

    public function setTel(int $tel): self
    {
        $this->tel = $tel;

        return $this;
    }

    /**
     * @return Collection<int, Avis>
     */
    public function getAvis(): Collection
    {
        return $this->avis;
    }

    public function addAvi(Avis $avi): self
    {
        if (!$this->avis->contains($avi)) {
            $this->avis->add($avi);
            $avi->setUser($this);
        }

        return $this;
    }

    public function removeAvi(Avis $avi): self
    {
        if ($this->avis->removeElement($avi)) {
            // set the owning side to null (unless already changed)
            if ($avi->getUser() === $this) {
                $avi->setUser(null);
            }
        }

        return $this;
    }
}
